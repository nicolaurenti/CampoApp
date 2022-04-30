package com.example.campoapp.domain

import com.example.campoapp.data.FodderResources
import com.example.campoapp.data.FodderResources.*
import com.example.campoapp.data.Observation
import com.example.campoapp.data.Observation.*
import com.example.campoapp.data.Table
import com.example.campoapp.data.Weather

class GetValueUseCase {

    private val table1 = Table(
        CAMPO_NATURAL_MALO_REGULAR,
        SUELO_ALCALINO_BARRO_BLANCO_PASTIZALES_DEGRADADOS,
        listOf(
            listOf(3.5, 5.4, 6.9, 5.9, 3.6, 3.0, 3.0, 3.7, 4.3, 8.0, 7.1, 5.3),
            listOf(8.7, 9.2, 10.3, 8.3, 5.0, 4.4, 4.5, 5.7, 7.5, 12.8, 15.1, 11.0),
            listOf(13.9, 13.1, 13.7, 10.8, 6.4, 5.8, 6.0, 7.7, 10.8, 17.7, 23.1, 16.8)
        ),
        listOf(5.0, 8.6, 12.1),
        listOf(1811, 3119, 4427)
    )

    private val table2

    private val tables = listOf(
        table1,
        table2,
        table3,
        table4,
        table5,
        table6,
        table7,
        table8,
        table9,
        table10,
        table11,
        table12,
        table13,
        table14,
        table15,
        table16,
        table17,
        table18,
        table19,
        table20
    )

    fun getKgMSList(weather: Weather, obs: Observation, fodderResources: FodderResources): List<Double?>? {
        tables.forEach {
            if ((fodderResources == it.fooderResources) && (obs == it.observation))
                return when (weather) {
                    Weather.MALO -> it.period[0]
                    Weather.REGULAR -> it.period[1]
                    Weather.BUENO -> it.period[2]
                }
        }
        return listOf()
    }
}
