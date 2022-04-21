package com.example.campoapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.campoapp.R
import com.example.campoapp.data.FodderResources
import com.example.campoapp.data.Potrero
import com.example.campoapp.databinding.ItemPotreroBinding
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
import com.example.campoapp.presentation.listener.OnPotreroListener

class PotreroAdapter(private val potreros: List<Potrero>, private val onPotreroListener: OnPotreroListener) :
    RecyclerView.Adapter<PotreroAdapter.PotreroViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PotreroViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_potrero, parent, false),
        onPotreroListener
    )

    override fun onBindViewHolder(holder: PotreroViewHolder, position: Int) {
        holder.bind(potreros[position])
    }
    override fun getItemCount() = potreros.size
    class PotreroViewHolder(itemView: View, private val onPotreroListener: OnPotreroListener?) : RecyclerView.ViewHolder(itemView){
        private val binding = ItemPotreroBinding.bind(itemView)
        fun bind(item: Potrero){
            binding.apply {
                potreroNameTextView.text = item.name
                resourceTitleTextView.text = getFodderResource(item.resources)
                observationTitleTextView.text = getObservation(item.observation)
            }
            binding.itemClient.setOnClickListener{
                onPotreroListener?.onPotreroClick()
            }
            binding.itemClient.setOnLongClickListener {
                onPotreroListener?.onPotreroLongClick(item.name)
                true
            }
        }

        private fun getFodderResource(fooderResources: FodderResources): String {
            return when (fooderResources) {
                CAMPO_NATURAL_MALO_REGULAR -> "Campo Natural Malo - Regular"
                NATURAL_REGULAR_BUENO ->"Natural Regular - Bueno"
                PROMOCION_RAIGRAS -> "Promoción raigrás"
                PASTURA_BASE_AGROPIRO ->"Pastura base Agropiro"
                PASTURA_BASE_AGROPIRO_CON_BPM ->"Pastura base Agropiro con BPM"
                PASTURA_BASE_FESTUCA -> "Pastura base Festuca"
                PASTURA_BASE_FESTUCA_CON_BPM ->"Pastura base Festuca con BPM"
                PASTURA_LOMA_BASE_ALFALFA ->"Pastura loma base Alfalfa"
                SORGO_DIFERIDO -> "Sorgo Diferido"
                SORGO_PASTOREO ->"Sorgo Pastoreo"
                AVENA_PASTOREO ->"Avena Pastoreo"
                RAIGRAS_ANUAL ->"Raigrás Anual"
                RASTROJO_TRIGO_CEBADA ->"Rastrojo Trigo/Cebada"
                RASTROJO_MAIZ ->"Rastrojo Maíz"
                RASTROJO_GIRASOL ->"Rastrojo Girasol"
            }
        }

        private fun getObservation( observation: Observation): String {
            return when(observation) {
                ANIO_IMPLANTACION ->"Año implantación"
                MANEJO_TRADICIONAL ->"Manejo tradicional"
                MANEJO_MEJORADO ->"Manejo mejorado"
                PARA_VACAS_DE_CRIA_DESPUES_DEL_DESTETE ->"Para vacas de cría después del destete"
                PASTOREO_EN_VERANO_CON_RECRIAS_O_VACAS_CON_TERNERO ->"Pastoreo en verano con recrías o vacas con ternero"
                PASTOREO_DIFERIDO ->"Pastoreo diferido"
                SIEMBRA_TARDIA ->"Siembra tardía"
                TIPO_TETRAPLOIDE ->"Tipo tetraploide"
                SUELO_ALCALINO_BARRO_BLANCO_PASTIZALES_DEGRADADOS ->"Suelo alcalino barro blanco-pastizales degradados"
                SUELO_BAJOS_OVEROS_BUENOS_DULCES_Y_MEDIA_LOMA ->"Suelos bajos overos buenos, dulces y media loma"
                CON_GLIFOSATO_VERANO ->"Con glifosato verano"
                CON_FESTUCOSIS ->"Con festucosis"
            }
        }
    }
}