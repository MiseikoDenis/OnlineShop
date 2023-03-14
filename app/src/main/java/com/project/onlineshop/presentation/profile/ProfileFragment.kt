package com.project.onlineshop.presentation.profile

import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.project.onlineshop.R
import com.project.onlineshop.databinding.FragmentProfileBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.project.onlineshop.presentation.util.GlideImageLoader
import com.project.onlineshop.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment(R.layout.fragment_profile) {

    override val viewModel by viewModels<ProfileViewModel>()
    private val viewBinding by viewBinding(FragmentProfileBinding::bind)
    private lateinit var galleryLauncher: ActivityResultLauncher<String?>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewBinding) {
            onLogOutClicked()
            onChangePhotoClicked()
            setPhotoObserver()
        }
    }

    private fun FragmentProfileBinding.onLogOutClicked() {
        logOutItem.setOnClickListener {
            findNavController().navigate(R.id.action_tabFragment_to_signInFragment)
        }
    }

    private fun FragmentProfileBinding.setPhotoObserver(){
        viewModel.imageUri.observe(viewLifecycleOwner){uri ->
            GlideImageLoader.loadImage(uri, photo)
        }
    }

    private fun FragmentProfileBinding.onChangePhotoClicked() {
        var uri: String
        galleryLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { imageUri ->
            if (imageUri != null) {
                uri = imageUri.toString()
                viewModel.updateUserPhoto(uri)
            }
        }
        changePhoto.setOnClickListener {
            openGallery()
        }
    }

    private fun openGallery() {
        galleryLauncher.launch("image/*")
    }
}