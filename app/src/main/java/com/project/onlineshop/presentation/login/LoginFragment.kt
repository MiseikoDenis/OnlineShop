package com.project.onlineshop.presentation.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.onlineshop.R
import by.kirich1409.viewbindingdelegate.viewBinding
import com.project.onlineshop.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private val viewBinding by viewBinding(FragmentLoginBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_login, container, false)
    }

}