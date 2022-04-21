package com.example.campoapp.presentation.mvp.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.campoapp.databinding.FragmentAnnualEstimateBinding


class AnnualEstimateFragment : Fragment() {

    interface AnnualEstimateListener {
        fun createEstimation(
            weather: String,
            acum: Int,
            animals: List<Int>
        )
        fun cancelButtonClicked()
    }

    private lateinit var binding: FragmentAnnualEstimateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnnualEstimateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var animalList: List<Int>
        binding.continueButton.setOnClickListener {
            with(binding) {
                animalList = listOf(
                    vacaValue.text.toString().toInt(),
                    vaquillonaValue.text.toString().toInt(),
                    terneroValue.text.toString().toInt(),
                    novillitoValue.text.toString().toInt(),
                    toroValue.text.toString().toInt()
                )
            }
            (activity as AnnualEstimateListener).createEstimation(
                binding.weatherSelector.selectedItem.toString(),
                binding.acumValue.toString().toInt(),
                animalList
            )
        }
        binding.cancelButton.setOnClickListener {
            (activity as AnnualEstimateListener).cancelButtonClicked()
        }
    }

    companion object {
        const val ANNUAL_ESTIMATE_TAG = "ANNUAL_ESTIMATE_TAG"

        @JvmStatic
        fun newInstance() = AnnualEstimateFragment()
    }
}