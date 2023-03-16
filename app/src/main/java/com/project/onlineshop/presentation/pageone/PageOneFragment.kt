package com.project.onlineshop.presentation.pageone

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.onlineshop.R
import by.kirich1409.viewbindingdelegate.viewBinding
import com.project.domain.interactor.UserInteractor
import com.project.domain.item.CategoryItem
import com.project.onlineshop.databinding.FragmentPageOneBinding
import com.project.onlineshop.presentation.base.BaseFragment
import com.project.onlineshop.presentation.pageone.category.CategoryAdapter
import com.project.onlineshop.presentation.pageone.latest.LatestAdapter
import com.project.onlineshop.presentation.util.GlideImageLoader
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PageOneFragment : BaseFragment(R.layout.fragment_page_one) {

    override val viewModel by viewModels<PageOneViewModel>()
    private val viewBinding by viewBinding(FragmentPageOneBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewBinding) {
            setPhotoObserver()
            setSpinner()
            setupRecyclerView()
            setupProductsLists()
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

    private fun FragmentPageOneBinding.setupRecyclerView(){
        val categoryList = listOf(
            CategoryItem(R.drawable.ic_phone, "Phones"),
            CategoryItem(R.drawable.ic_headphone, "Headphones"),
            CategoryItem(R.drawable.ic_gamepad, "Games"),
            CategoryItem(R.drawable.ic_car, "Cars"),
            CategoryItem(R.drawable.ic_bed, "Furniture"),
            CategoryItem(R.drawable.ic_robot, "Kids"),
        )

        categoryRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = CategoryAdapter(categoryList)
        }
    }

    private fun FragmentPageOneBinding.setupProductsLists(){
        latestList.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            viewModel.latestProducts.observe(viewLifecycleOwner){list->
                adapter = LatestAdapter(list)
            }
        }
        viewModel.loadLatestProducts()
    }

}