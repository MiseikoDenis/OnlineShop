package com.project.onlineshop.presentation.page1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.onlineshop.R
import by.kirich1409.viewbindingdelegate.viewBinding
import com.project.onlineshop.databinding.FragmentPage1Binding


class Page1Fragment : Fragment() {

    private val viewBinding by viewBinding(FragmentPage1Binding::bind)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_page1, container, false)
    }

}