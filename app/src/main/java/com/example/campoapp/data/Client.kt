package com.example.campoapp.data

import com.google.gson.annotations.SerializedName

data class Client(

    @SerializedName("name") var name: String,

    @SerializedName("potreros") val potreros: MutableList<Potrero> = mutableListOf())
{
    fun getMaxCattle(): Int {
        var maxCattle = 0
        return maxCattle
    }

    fun getActualCattle(): Int {
        var actualCattle = 0
        potreros.forEach{ actualCattle += it.actualCattle}
        return actualCattle
    }

    fun getHectares(): Int {
        var cantHectares = 0
        potreros.forEach { cantHectares += it.hectares }
        return cantHectares
    }
}
