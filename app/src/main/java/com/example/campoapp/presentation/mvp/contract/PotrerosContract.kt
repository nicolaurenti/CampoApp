package com.example.campoapp.presentation.mvp.contract

import androidx.fragment.app.Fragment
import com.example.campoapp.data.Potrero
import com.example.campoapp.presentation.listener.OnPotreroListener

interface PotrerosContract {

    interface Model {
        fun addPotrero(potrero: Potrero)
        fun getPotreros(): List<Potrero>
        fun setClientName(client: String)
    }

    interface View {
        fun updateList(potreros: List<Potrero>, onPotreroListener: OnPotreroListener)
        fun showFragment(fragment: Fragment, tag: String)
    }

    interface Presenter {
        fun updateList(potrero: Potrero, onPotreroListener: OnPotreroListener)
        fun addPotrero(potrero: Potrero, onClientInformationListener: OnPotreroListener)
        fun setClientName(client: String, onPotreroListener: OnPotreroListener)
    }
}