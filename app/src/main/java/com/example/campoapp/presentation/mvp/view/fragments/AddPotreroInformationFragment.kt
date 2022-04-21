package com.example.campoapp.presentation.mvp.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.campoapp.R
import com.example.campoapp.data.FodderResources
import com.example.campoapp.data.Potrero
import com.example.campoapp.data.FodderResources.CAMPO_NATURAL_MALO_REGULAR
import com.example.campoapp.data.FodderResources.NATURAL_REGULAR_BUENO
import com.example.campoapp.data.FodderResources.PROMOCION_RAIGRAS
import com.example.campoapp.data.FodderResources.PASTURA_BASE_AGROPIRO
import com.example.campoapp.data.FodderResources.PASTURA_BASE_AGROPIRO_CON_BPM
import com.example.campoapp.data.FodderResources.PASTURA_BASE_FESTUCA
import com.example.campoapp.data.FodderResources.PASTURA_BASE_FESTUCA_CON_BPM
import com.example.campoapp.data.FodderResources.PASTURA_LOMA_BASE_ALFALFA
import com.example.campoapp.data.FodderResources.SORGO_DIFERIDO
import com.example.campoapp.data.FodderResources.SORGO_PASTOREO
import com.example.campoapp.data.FodderResources.AVENA_PASTOREO
import com.example.campoapp.data.FodderResources.RAIGRAS_ANUAL
import com.example.campoapp.data.FodderResources.RASTROJO_TRIGO_CEBADA
import com.example.campoapp.data.FodderResources.RASTROJO_MAIZ
import com.example.campoapp.data.FodderResources.RASTROJO_GIRASOL
import com.example.campoapp.data.Observation
import com.example.campoapp.data.Observation.ANIO_IMPLANTACION
import com.example.campoapp.data.Observation.MANEJO_TRADICIONAL
import com.example.campoapp.data.Observation.MANEJO_MEJORADO
import com.example.campoapp.data.Observation.PARA_VACAS_DE_CRIA_DESPUES_DEL_DESTETE
import com.example.campoapp.data.Observation.PASTOREO_EN_VERANO_CON_RECRIAS_O_VACAS_CON_TERNERO
import com.example.campoapp.data.Observation.PASTOREO_DIFERIDO
import com.example.campoapp.data.Observation.SIEMBRA_TARDIA
import com.example.campoapp.data.Observation.TIPO_TETRAPLOIDE
import com.example.campoapp.data.Observation.SUELO_ALCALINO_BARRO_BLANCO_PASTIZALES_DEGRADADOS
import com.example.campoapp.data.Observation.SUELO_BAJOS_OVEROS_BUENOS_DULCES_Y_MEDIA_LOMA
import com.example.campoapp.data.Observation.CON_GLIFOSATO_VERANO
import com.example.campoapp.data.Observation.CON_FESTUCOSIS
import com.example.campoapp.data.Weather
import com.example.campoapp.databinding.FragmentAddPotreroInformationBinding

class AddPotreroInformationFragment : Fragment() {

    interface AddPotreroInterface {
        fun addPotreroClicked()
        fun addPotrero(potrero: Potrero)
        fun cancelButtonClicked()
    }

    private lateinit var binding: FragmentAddPotreroInformationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddPotreroInformationBinding.inflate(inflater, container, false)
        setSpinnerAdapter(R.array.fodder_resources_list, binding.fodderResourceSelector)
        setSpinnerAdapter(R.array.observation_list, binding.observationSelector)
        setOnClickListener()
        return binding.root
    }

    private fun setOnClickListener() {
        binding.cancelAddPotreroButton.setOnClickListener {
            (activity as AddPotreroInterface).cancelButtonClicked()
        }
        binding.continueAddPotreroButton.setOnClickListener {
            with(binding) {
                (activity as AddPotreroInterface).addPotrero(
                    Potrero(
                        "",
                        newPotreroEditText.text.toString(),
                        0,
                        0,
                        getFooderResources(fodderResourceSelector.selectedItem.toString()),
                        //periodSelector.selectedItem.toString(),
                        getObservation(observationSelector.selectedItem.toString())
                    )
                )
            }
        }
    }

    private fun getWeather(weather: String): Weather {
        return when(weather) {
            "malo" -> Weather.MALO
            "normal" -> Weather.REGULAR
            "bueno" -> Weather.BUENO
            else -> Weather.MALO
        }
    }

    private fun getObservation(observation: String): Observation {
        return when(observation) {
            "Año implantación" -> ANIO_IMPLANTACION
            "Manejo tradicional" -> MANEJO_TRADICIONAL
            "Manejo mejorado" -> MANEJO_MEJORADO
            "Para vacas de cría después del destete" -> PARA_VACAS_DE_CRIA_DESPUES_DEL_DESTETE
            "Pastoreo en verano con recrías o vacas con ternero" -> PASTOREO_EN_VERANO_CON_RECRIAS_O_VACAS_CON_TERNERO
            "Pastoreo diferido" -> PASTOREO_DIFERIDO
            "Siembra tardía" -> SIEMBRA_TARDIA
            "Tipo tetraploide" -> TIPO_TETRAPLOIDE
            "Suelo alcalino barro blanco-pastizales degradados" -> SUELO_ALCALINO_BARRO_BLANCO_PASTIZALES_DEGRADADOS
            "Suelos bajos overos buenos, dulces y media loma" -> SUELO_BAJOS_OVEROS_BUENOS_DULCES_Y_MEDIA_LOMA
            "Con glifosato verano" -> CON_GLIFOSATO_VERANO
            "Con festucosis" -> CON_FESTUCOSIS
            else -> ANIO_IMPLANTACION
        }
    }
    private fun getFooderResources(fodderResource: String): FodderResources {
        return when (fodderResource) {
            "Campo Natural Malo - Regular" -> CAMPO_NATURAL_MALO_REGULAR
            "Natural Regular - Bueno" -> NATURAL_REGULAR_BUENO
            "Promoción raigrás" -> PROMOCION_RAIGRAS
            "Pastura base Agropiro" -> PASTURA_BASE_AGROPIRO
            "Pastura base Agropiro con BPM" -> PASTURA_BASE_AGROPIRO_CON_BPM
            "Pastura base Festuca" -> PASTURA_BASE_FESTUCA
            "Pastura base Festuca con BPM" -> PASTURA_BASE_FESTUCA_CON_BPM
            "Pastura loma base Alfalfa" -> PASTURA_LOMA_BASE_ALFALFA
            "Sorgo Diferido" -> SORGO_DIFERIDO
            "Sorgo Pastoreo" -> SORGO_PASTOREO
            "Avena Pastoreo" -> AVENA_PASTOREO
            "Raigrás Anual" -> RAIGRAS_ANUAL
            "Rastrojo Trigo/Cebada" -> RASTROJO_TRIGO_CEBADA
            "Rastrojo Maíz" -> RASTROJO_MAIZ
            "Rastrojo Girasol" -> RASTROJO_GIRASOL
            else -> CAMPO_NATURAL_MALO_REGULAR
        }
    }

    private fun setSpinnerAdapter(spinnerArray: Int, spinner: Spinner) {
        context?.let {
            ArrayAdapter.createFromResource(
                it,
                spinnerArray,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner.adapter = adapter
            }
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.fodderResourceSelector
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            AddPotreroInformationFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
