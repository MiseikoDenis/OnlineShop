package com.project.onlineshop.presentation.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.project.onlineshop.R
import by.kirich1409.viewbindingdelegate.viewBinding
import com.project.onlineshop.databinding.FragmentLoginBinding
import com.project.onlineshop.databinding.FragmentSignInBinding
import com.project.onlineshop.presentation.base.BaseFragment
import com.project.onlineshop.presentation.tab.TabViewModel


class LoginFragment : BaseFragment(R.layout.fragment_login) {

    override val viewModel by viewModels<LoginViewModel>()
    private val viewBinding by viewBinding(FragmentLoginBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewBinding){
            onLoginPressed()
        }
    }

    private fun FragmentLoginBinding.onLoginPressed() {
        loginButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_tabFragment)
        }
    }
}