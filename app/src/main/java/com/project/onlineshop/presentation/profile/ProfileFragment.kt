package com.project.onlineshop.presentation.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.onlineshop.R
import com.project.onlineshop.databinding.FragmentProfileBinding
import by.kirich1409.viewbindingdelegate.viewBinding

class ProfileFragment : Fragment() {

    private val viewBinding by viewBinding(FragmentProfileBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_profile, container, false)
    }
}