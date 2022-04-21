package com.example.campoapp.presentation.mvp.presenter

import androidx.fragment.app.Fragment
import com.example.campoapp.data.Potrero
import com.example.campoapp.presentation.listener.OnPotreroListener
import com.example.campoapp.presentation.mvp.contract.PotrerosContract

class PotrerosPresenter(private val model: PotrerosContract.Model, private val view: PotrerosContract.View): PotrerosContract.Presenter {

    override fun updateList(potrero: Potrero, onPotreroListener: OnPotreroListener) {
        model.addPotrero(potrero)
        view.updateList(model.getPotreros(), onPotreroListener)
    }

    override fun addPotrero(potrero: Potrero, onPotreroListener: OnPotreroListener) {
        model.addPotrero(potrero)
        view.updateList(model.getPotreros(), onPotreroListener)
    }

    override fun setClientName(client: String, onPotreroListener: OnPotreroListener) {
        model.setClientName(client)
        view.updateList(model.getPotreros(), onPotreroListener)
    }

}