package com.project.onlineshop.presentation.signin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.onlineshop.R
import com.project.onlineshop.databinding.FragmentSignInBinding
import by.kirich1409.viewbindingdelegate.viewBinding


class SignInFragment : Fragment() {

    private val viewBinding by viewBinding(FragmentSignInBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }
}