package com.project.onlineshop.presentation.pageone

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.project.onlineshop.R
import by.kirich1409.viewbindingdelegate.viewBinding
import com.project.domain.interactor.UserInteractor
import com.project.onlineshop.databinding.FragmentPageOneBinding
import com.project.onlineshop.presentation.base.BaseFragment
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

        viewModel.text.observe(viewLifecycleOwner){
            viewBinding.text.text = it
        }
        viewModel.getUser()

    }
}