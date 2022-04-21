package com.example.campoapp.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.campoapp.presentation.mvp.view.fragments.ClientInformationFragment
import com.example.campoapp.presentation.mvp.view.fragments.PotrerosFragment

class ClientInformationViewPagerAdapter(fragment: FragmentActivity): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return if (position == 0){
            ClientInformationFragment.newInstance()
        } else {
            PotrerosFragment.newInstance()
        }
    }
}