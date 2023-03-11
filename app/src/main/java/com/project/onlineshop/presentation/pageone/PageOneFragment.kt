package com.project.onlineshop.presentation.pageone

import androidx.fragment.app.viewModels
import com.project.onlineshop.R
import by.kirich1409.viewbindingdelegate.viewBinding
import com.project.onlineshop.databinding.FragmentPageOneBinding
import com.project.onlineshop.presentation.base.BaseFragment


class PageOneFragment : BaseFragment(R.layout.fragment_page_one) {

    override val viewModel by viewModels<PageOneViewModel>()
    private val viewBinding by viewBinding(FragmentPageOneBinding::bind)



}