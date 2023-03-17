package com.project.onlineshop.presentation.pageone

import android.database.Cursor
import android.database.MatrixCursor
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ArrayAdapter
import android.widget.CursorAdapter
import android.widget.SearchView
import android.widget.SearchView.OnQueryTextListener
import android.widget.SimpleCursorAdapter
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.onlineshop.R
import by.kirich1409.viewbindingdelegate.viewBinding
import com.project.domain.interactor.ProductInteractor
import com.project.domain.item.CategoryItem
import com.project.domain.model.LatestProduct
import com.project.onlineshop.databinding.FragmentPageOneBinding
import com.project.onlineshop.presentation.base.BaseFragment
import com.project.onlineshop.presentation.pageone.category.CategoryAdapter
import com.project.onlineshop.presentation.pageone.latest.LatestAdapter
import com.project.onlineshop.presentation.pageone.sale.SaleAdapter
import com.project.onlineshop.presentation.util.GlideImageLoader
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import javax.inject.Inject

@AndroidEntryPoint
class PageOneFragment : BaseFragment(R.layout.fragment_page_one) {

    override val viewModel by viewModels<PageOneViewModel>()
    private val viewBinding by viewBinding(FragmentPageOneBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewBinding) {
            setPhotoObserver()
            setSpinner()
            setupCategory()
            setupProductsLists()
            setupSearch()
        }
    }

    private fun FragmentPageOneBinding.setPhotoObserver() {
        viewModel.imageUri.observe(viewLifecycleOwner) { uri ->
            GlideImageLoader.loadImage(uri, userAvatar)
        }
    }

    private fun FragmentPageOneBinding.setSpinner() {
        val adapter = ArrayAdapter(
            requireContext(),
            R.layout.my_spinner_item,
            resources.getStringArray(R.array.locations)
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerLocation.adapter = adapter
    }

    private fun FragmentPageOneBinding.setupCategory() {
        val categoryList = listOf(
            CategoryItem(R.drawable.ic_phone, "Phones"),
            CategoryItem(R.drawable.ic_headphone, "Headphones"),
            CategoryItem(R.drawable.ic_gamepad, "Games"),
            CategoryItem(R.drawable.ic_car, "Cars"),
            CategoryItem(R.drawable.ic_bed, "Furniture"),
            CategoryItem(R.drawable.ic_robot, "Kids"),
        )

        categoryRecycler.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = CategoryAdapter(categoryList)
        }
    }

    private fun FragmentPageOneBinding.setupSearch() {

        searchEdit.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.searchWords(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.searchWords(newText)
                return true
            }
        })

        searchEdit.setOnSuggestionListener(object : SearchView.OnSuggestionListener {
            override fun onSuggestionSelect(position: Int): Boolean {
                return false
            }

            override fun onSuggestionClick(position: Int): Boolean {
                val cursor = searchEdit.suggestionsAdapter.getItem(position) as Cursor
                val wordIndex = cursor.getColumnIndex("word")
                if (wordIndex >= 0) {
                    val selectedWord = cursor.getString(wordIndex)
                    searchEdit.setQuery(selectedWord, true)
                }
                return true
            }
        })

        viewModel.searchResult.observe(viewLifecycleOwner) { words ->
            if (words.isEmpty()) {
                searchEdit.apply {
                    suggestionsAdapter = null
                }
            } else {
                val cursor = createCursor(words)
                val adapter = SimpleCursorAdapter(
                    requireContext(),
                    android.R.layout.simple_list_item_1,
                    cursor,
                    arrayOf("word"),
                    intArrayOf(android.R.id.text1),
                    CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
                )
                searchEdit.suggestionsAdapter = adapter
            }
        }
    }

    private fun createCursor(words: List<String>): MatrixCursor {
        val columns = arrayOf("_id", "word")
        val cursor = MatrixCursor(columns)
        for ((index, word) in words.withIndex()) {
            cursor.addRow(arrayOf(index, word))
        }
        return cursor

    }


    private fun FragmentPageOneBinding.setupProductsLists() {
        viewModel.loadData()
        latestList.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            viewModel.latestProducts.observe(viewLifecycleOwner) { list ->
                adapter = list?.let { LatestAdapter(it) }
            }
        }
        saleList.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            viewModel.saleProducts.observe(viewLifecycleOwner) { list ->
                adapter = list?.let { SaleAdapter(it) }
            }
        }
    }

}