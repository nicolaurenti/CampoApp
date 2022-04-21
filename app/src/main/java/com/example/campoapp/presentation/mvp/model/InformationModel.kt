package com.example.campoapp.presentation.mvp.model

import com.example.campoapp.data.Potrero
import com.example.campoapp.data.Weather
import com.example.campoapp.domain.GetClientInformationUseCase
import com.example.campoapp.presentation.mvp.contract.InformationContract
import java.time.LocalDate

class InformationModel(private var getClientInformationUseCase: GetClientInformationUseCase) : InformationContract.Model {

    private lateinit var clientName: String
    private var potreros = mutableListOf<Potrero>()

    override fun getAnnualEstimate(weather: String, acum: Int, animals: List<Int>): Int {
        return (getKgMSAnualTotal() / getIndiceConsumo(animals)).toInt()
    }

    override fun setClientName(client: String) {
        clientName = client
        potreros = getClientInformationUseCase.getPotreros(client)
    }

    override fun addPotrero(potrero: Potrero) {
        potrero.client = clientName
        potreros.add(potrero)
        getClientInformationUseCase.addPotrero(potreros)
    }

    override fun getPotreros(): List<Potrero> {
        return potreros
    }

    private fun getKgMSAnualTotal(): Double {
        var result = 0.0
        potreros.forEach {
            result += it.getKgMSAnual(Weather.REGULAR, LocalDate.ofEpochDay(System.currentTimeMillis()))
        }
        return result
    }

    private fun getIndiceConsumo(animals: List<Int>): Double {
        return animals[0] * 9.9 + animals[1] * 6.8 + animals[2] * 5.7 + animals[3] * 9.1 + animals[4] * 13.0
    }

}
