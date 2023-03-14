package com.project.onlineshop.presentation.login

import android.os.Bundle
import android.text.InputType
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.project.onlineshop.R
import by.kirich1409.viewbindingdelegate.viewBinding
import com.project.onlineshop.databinding.FragmentLoginBinding
import com.project.onlineshop.databinding.FragmentSignInBinding
import com.project.onlineshop.presentation.base.BaseFragment
import com.project.onlineshop.presentation.tab.TabViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment(R.layout.fragment_login) {

    override val viewModel by viewModels<LoginViewModel>()
    private val viewBinding by viewBinding(FragmentLoginBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewBinding) {
            onLoginPressed()
            onPasswordVisibilityPressed()
        }

    }

    private fun FragmentLoginBinding.onLoginPressed() {
        loginButton.setOnClickListener {
            if (viewModel.onLoginClicked(
                    firstNameEdit.text.toString(),
                    passwordEdit.text.toString()
                )
            ) {
                findNavController().navigate(R.id.action_loginFragment_to_tabFragment)
            } else {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.wrong_login_or_password),
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
    }

    private fun FragmentLoginBinding.onPasswordVisibilityPressed() {
        showPasswordBtn.setOnClickListener {
            viewModel.togglePasswordVisibility()
        }

        viewModel.showPassword.observe(viewLifecycleOwner) { showPassword ->
            if (showPassword) {
                passwordEdit.transformationMethod = HideReturnsTransformationMethod.getInstance()
            } else {
                passwordEdit.transformationMethod = PasswordTransformationMethod.getInstance()
            }
            passwordEdit.setSelection(passwordEdit.text?.length ?: 0)
        }
    }
}