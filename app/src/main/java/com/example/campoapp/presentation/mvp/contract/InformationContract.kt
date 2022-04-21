package com.example.campoapp.presentation.mvp.contract

import androidx.fragment.app.Fragment
import com.example.campoapp.data.Potrero
import com.example.campoapp.presentation.listener.OnPotreroListener

interface InformationContract {
    interface Model {
        fun getAnnualEstimate(weather: String, acum: Int, animals: List<Int>): Int
        fun addPotrero(potrero: Potrero)
        fun getPotreros(): List<Potrero>
        fun setClientName(client: String)
    }

    interface View {
        fun showFragment(fragment: Fragment, tag: String)
        fun showAnnualEstimate(annualEstimate: Int)
        fun setClientName(client: String)
    }

    interface Presenter {
        fun addPotrero(potrero: Potrero, onClientInformationListener: OnPotreroListener)
        fun showFragment(fragment: Fragment, tag: String)
        fun showAnnualEstimate(weather: String, acum: Int, animals: List<Int>)
        fun setClientName(client: String, onPotreroListener: OnPotreroListener)
    }
}
