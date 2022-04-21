package com.example.campoapp.presentation.mvp.model

import com.example.campoapp.data.Potrero
import com.example.campoapp.domain.GetClientInformationUseCase
import com.example.campoapp.presentation.mvp.contract.PotrerosContract

class PotrerosModel(private var getClientInformationUseCase: GetClientInformationUseCase): PotrerosContract.Model {

    private lateinit var clientName: String
    private var potreros = mutableListOf<Potrero>()

    override fun setClientName(client: String) {
        clientName = client
        potreros = getClientInformationUseCase.getPotreros(client)
    }

    override fun addPotrero(potrero: Potrero) {
        // potrero.client = clientName
        potreros.add(potrero)
        getClientInformationUseCase.addPotrero(potreros)
    }

    override fun getPotreros(): List<Potrero> {
        return potreros
    }
}