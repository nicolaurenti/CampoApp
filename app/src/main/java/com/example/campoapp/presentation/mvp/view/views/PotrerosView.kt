package com.example.campoapp.presentation.mvp.view.views

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.campoapp.data.Potrero
import com.example.campoapp.databinding.FragmentPotrerosScreenBinding
import com.example.campoapp.presentation.adapter.PotreroAdapter
import com.example.campoapp.presentation.listener.OnPotreroListener
import com.example.campoapp.presentation.mvp.contract.PotrerosContract
import com.example.campoapp.presentation.mvp.view.FragmentView
import com.example.campoapp.presentation.mvp.view.activities.InformationActivity

class PotrerosView(
    activity: FragmentActivity?,
    private val binding: FragmentPotrerosScreenBinding
) : PotrerosContract.View, FragmentView(activity) {

    override fun updateList(potreros: List<Potrero>, onPotreroListener: OnPotreroListener) {
        binding.potrerosRecycler.layoutManager = LinearLayoutManager(context)
        binding.potrerosRecycler.adapter = PotreroAdapter(potreros, onPotreroListener)
    }

    override fun showFragment(fragment: Fragment, tag: String) {
        (context as InformationActivity).supportFragmentManager.beginTransaction().add(
            binding.potrerosFrameLayout.id, fragment, tag
        ).commit()
    }
}