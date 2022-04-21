package com.example.campoapp.data

import com.example.campoapp.domain.GetValueUseCase
import com.google.gson.annotations.SerializedName
import java.time.LocalDate
import java.util.*

data class Potrero(
    @SerializedName("client") var client: String,
    @SerializedName("name") val name: String,
    @SerializedName("hectares") val hectares: Int,
    @SerializedName("actualCattle") val actualCattle: Int,
    @SerializedName("resources") val resources: FodderResources,
    @SerializedName("observation") val observation: Observation
) {
    fun getKgMSAnual(weather: Weather,date: LocalDate): Double {
        val table = GetValueUseCase().getKgMSList(weather, observation, resources)
        return 0.0
    }
}
