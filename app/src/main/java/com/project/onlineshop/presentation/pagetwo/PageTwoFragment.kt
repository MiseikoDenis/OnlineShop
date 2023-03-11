package com.project.onlineshop.presentation.pagetwo

import androidx.fragment.app.viewModels
import com.project.onlineshop.R
import by.kirich1409.viewbindingdelegate.viewBinding
import com.project.onlineshop.databinding.FragmentPageTwoBinding
import com.project.onlineshop.presentation.base.BaseFragment


class PageTwoFragment : BaseFragment(R.layout.fragment_page_two) {

    override val viewModel by viewModels<PageTwoViewModel>()
    private val viewBinding by viewBinding(FragmentPageTwoBinding::bind)



}