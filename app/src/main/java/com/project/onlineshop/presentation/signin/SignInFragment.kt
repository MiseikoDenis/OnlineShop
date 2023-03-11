package com.project.onlineshop.presentation.signin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.project.onlineshop.R
import com.project.onlineshop.databinding.FragmentSignInBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.project.onlineshop.presentation.base.BaseFragment


class SignInFragment : BaseFragment(R.layout.fragment_sign_in) {

    override val viewModel by viewModels<SignInViewModel>()
    private val viewBinding by viewBinding(FragmentSignInBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewBinding) {
            onLoginPressed()
            onRegisterPressed()
        }

    }

    private fun FragmentSignInBinding.onLoginPressed() {
        logIn.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_loginFragment)
        }
    }

    private fun FragmentSignInBinding.onRegisterPressed() {
        signInButton.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_tabFragment)
        }
    }
}