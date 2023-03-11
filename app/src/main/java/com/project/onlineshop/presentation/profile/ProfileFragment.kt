package com.project.onlineshop.presentation.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.project.onlineshop.R
import com.project.onlineshop.databinding.FragmentProfileBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.project.onlineshop.presentation.base.BaseFragment
import com.project.onlineshop.presentation.tab.TabViewModel

class ProfileFragment : BaseFragment(R.layout.fragment_profile) {

    override val viewModel by viewModels<ProfileViewModel>()
    private val viewBinding by viewBinding(FragmentProfileBinding::bind)


}