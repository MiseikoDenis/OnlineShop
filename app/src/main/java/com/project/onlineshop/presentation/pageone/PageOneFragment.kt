package com.project.onlineshop.presentation.pageone

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.project.onlineshop.R
import by.kirich1409.viewbindingdelegate.viewBinding
import com.project.domain.interactor.UserInteractor
import com.project.onlineshop.databinding.FragmentPageOneBinding
import com.project.onlineshop.presentation.base.BaseFragment
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
}