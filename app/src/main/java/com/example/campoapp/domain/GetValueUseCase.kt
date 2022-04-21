package com.example.campoapp.domain

import com.example.campoapp.data.FodderResources
import com.example.campoapp.data.FodderResources.RASTROJO_GIRASOL
import com.example.campoapp.data.FodderResources.RASTROJO_MAIZ
import com.example.campoapp.data.FodderResources.RASTROJO_TRIGO_CEBADA
import com.example.campoapp.data.FodderResources.RAIGRAS_ANUAL
import com.example.campoapp.data.FodderResources.AVENA_PASTOREO
import com.example.campoapp.data.FodderResources.PASTURA_LOMA_BASE_ALFALFA
import com.example.campoapp.data.FodderResources.SORGO_PASTOREO
import com.example.campoapp.data.FodderResources.SORGO_DIFERIDO
import com.example.campoapp.data.Observation
import com.example.campoapp.data.Observation.ANIO_IMPLANTACION
import com.example.campoapp.data.Observation.MANEJO_TRADICIONAL
import com.example.campoapp.data.Observation.MANEJO_MEJORADO
import com.example.campoapp.data.Observation.PASTOREO_DIFERIDO
import com.example.campoapp.data.Observation.PARA_VACAS_DE_CRIA_DESPUES_DEL_DESTETE
import com.example.campoapp.data.Observation.SIEMBRA_TARDIA
import com.example.campoapp.data.Observation.PASTOREO_EN_VERANO_CON_RECRIAS_O_VACAS_CON_TERNERO
import com.example.campoapp.data.Observation.TIPO_TETRAPLOIDE
import com.example.campoapp.data.Table
import com.example.campoapp.data.Weather

class GetValueUseCase {

    private val TableA = Table(PASTURA_LOMA_BASE_ALFALFA, ANIO_IMPLANTACION, listOf(null, listOf(null, null, null, 35.0, 12.0, null, null, null, null, null, null, null), null), listOf(null, 3.9, null), listOf(null,1422, null))
    private val TableB = Table(PASTURA_LOMA_BASE_ALFALFA, MANEJO_TRADICIONAL, listOf(null, listOf(null, null, null, 35.0, 12.0, null, null, null, null, null, null, null), null), listOf(null, 3.9, null), listOf(null,1422, null))
    private val TableC = Table(PASTURA_LOMA_BASE_ALFALFA, MANEJO_MEJORADO, listOf(null, listOf(null, null, null, 35.0, 12.0, null, null, null, null, null, null, null), null), listOf(null, 3.9, null), listOf(null,1422, null))
    private val TableD = Table(SORGO_DIFERIDO, MANEJO_MEJORADO, listOf(null, listOf(null, null, null, 35.0, 12.0, null, null, null, null, null, null, null), null), listOf(null, 3.9, null), listOf(null,1422, null))
    private val TableE = Table(SORGO_PASTOREO, PARA_VACAS_DE_CRIA_DESPUES_DEL_DESTETE, listOf(null, listOf(null, null, null, 35.0, 12.0, null, null, null, null, null, null, null), null), listOf(null, 3.9, null), listOf(null,1422, null))
    private val TableF = Table(AVENA_PASTOREO, PASTOREO_EN_VERANO_CON_RECRIAS_O_VACAS_CON_TERNERO, listOf(null, listOf(null, null, null, 35.0, 12.0, null, null, null, null, null, null, null), null), listOf(null, 3.9, null), listOf(null,1422, null))
    private val TableG = Table(AVENA_PASTOREO, MANEJO_TRADICIONAL, listOf(null, listOf(null, null, null, 35.0, 12.0, null, null, null, null, null, null, null), null), listOf(null, 3.9, null), listOf(null,1422, null))

    private val TableH = Table(AVENA_PASTOREO, SIEMBRA_TARDIA, listOf(null, listOf(null, null, null, null, null, 12.0, 10.0, 12.0, 17.0, 15.0, 11.0, 8.0), null), listOf(null, 7.1, null), listOf(null,2595, null))

    private val TableI = Table(RAIGRAS_ANUAL, TIPO_TETRAPLOIDE, listOf(null, listOf(null, null, null, 12.0, 15.0, 14.0, 13.0, 15.0, 20.0, 22.0, 16.0, null), null), listOf(null, 10.6, null), listOf(null, 3875, null))
    private val TableJ = Table(RASTROJO_TRIGO_CEBADA, null, listOf(null, listOf(35.0, 20.0, 8.0, null, null, null, null, null, null, null, null, null), null), listOf(null, 5.3, null), listOf(null, 1893, null))
    private val TableK = Table(RASTROJO_MAIZ, null, listOf(null, listOf(null, null, null, null, 65.0, 35.0, 15.0, null, null, null, null, null), null), listOf(null, 9.6, null), listOf(null, 3530, null))
    private val TableL = Table(RASTROJO_GIRASOL, null, listOf(null, listOf(null, null, null, 35.0, 12.0, null, null, null, null, null, null, null), null), listOf(null, 3.9, null), listOf(null,1422, null))

    private val tables = listOf(TableA, TableB, TableC, TableD, TableE, TableF, TableG, TableH, TableI, TableJ, TableK, TableL)

    fun getKgMSList(weather: Weather, obs: Observation, fodderResources: FodderResources): List<Double?>? {
        tables.forEach {
            if ((fodderResources == it.fooderResources) && (obs == it.observation))
                return when(weather) {
                    Weather.MALO -> it.period[0]
                    Weather.REGULAR -> it.period[1]
                    Weather.BUENO -> it.period[2]
                }
        }
        return listOf()
    }
}
