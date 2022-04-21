package com.example.campoapp.presentation.mvp.presenter

import androidx.fragment.app.Fragment
import com.example.campoapp.data.Potrero
import com.example.campoapp.presentation.listener.OnPotreroListener
import com.example.campoapp.presentation.mvp.contract.InformationContract

class InformationPresenter(
    private val model: InformationContract.Model,
    private val view: InformationContract.View
): InformationContract.Presenter {


    override fun showFragment(fragment: Fragment, tag: String) {
        view.showFragment(fragment, tag)
    }

    override fun showAnnualEstimate(weather: String, acum: Int, animals: List<Int>) {
        view.showAnnualEstimate(model.getAnnualEstimate(weather, acum, animals))
    }

    override fun addPotrero(potrero: Potrero, onPotreroListener: OnPotreroListener) {
        model.addPotrero(potrero)
    }

    override fun setClientName(client: String, onPotreroListener: OnPotreroListener) {
        model.setClientName(client)
        view.setClientName(client)
    }

}
