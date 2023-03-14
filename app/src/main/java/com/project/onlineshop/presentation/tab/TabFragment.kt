package com.project.onlineshop.presentation.tab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.project.onlineshop.R
import com.project.onlineshop.databinding.FragmentTabBinding
import com.project.onlineshop.presentation.base.BaseFragment
import com.project.onlineshop.presentation.base.BaseViewModel
import com.project.onlineshop.presentation.pageone.PageOneFragment
import com.project.onlineshop.presentation.pagetwo.PageTwoFragment
import com.project.onlineshop.presentation.profile.ProfileFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TabFragment : BaseFragment(R.layout.fragment_tab) {

    private val viewBinding by viewBinding(FragmentTabBinding::bind)
    override val viewModel by viewModels<TabViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = TabPagerAdapter(childFragmentManager, lifecycle)
        adapter.addFragment(PageOneFragment(), R.drawable.ic_home)
        adapter.addFragment(ProfileFragment(), R.drawable.ic_profile)

        viewBinding.viewPager.adapter = adapter

        TabLayoutMediator(viewBinding.tabLayout, viewBinding.viewPager) { tab, position ->
            tab.setIcon(adapter.getIcon(position))
        }.attach()
    }

    inner class TabPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle) :
        FragmentStateAdapter(fm, lifecycle) {

        private val fragments = mutableListOf<Fragment>()
        private val icons = mutableListOf<Int>()

        override fun getItemCount(): Int = fragments.size

        override fun createFragment(position: Int): Fragment = fragments[position]

        fun addFragment(fragment: Fragment, icon: Int) {
            fragments.add(fragment)
            icons.add(icon)
        }

        fun getIcon(position: Int): Int = icons[position]
    }

}