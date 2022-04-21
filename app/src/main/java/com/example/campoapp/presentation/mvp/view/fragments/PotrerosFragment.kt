package com.example.campoapp.presentation.mvp.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.campoapp.data.Potrero
import com.example.campoapp.databinding.FragmentPotrerosScreenBinding
import com.example.campoapp.domain.GetClientInformationUseCase
import com.example.campoapp.presentation.listener.OnPotreroListener
import com.example.campoapp.presentation.mvp.contract.PotrerosContract
import com.example.campoapp.presentation.mvp.model.PotrerosModel
import com.example.campoapp.presentation.mvp.presenter.PotrerosPresenter
import com.example.campoapp.presentation.mvp.view.views.PotrerosView
import com.example.campoapp.presentation.mvp.view.activities.InformationActivity.Companion.ADD_POTRERO_TAG

class PotrerosFragment : Fragment(), OnPotreroListener {

    interface SetFragmentsInterface {
        fun getClientName() : String
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    private lateinit var  binding: FragmentPotrerosScreenBinding
    private lateinit var presenter: PotrerosContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPotrerosScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun updateList(potrero: Potrero, onPotreroListener: OnPotreroListener) {
        presenter.updateList(potrero, onPotreroListener)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter = PotrerosPresenter(PotrerosModel(GetClientInformationUseCase(activity)), PotrerosView(activity, binding))
        presenter.setClientName((activity as SetFragmentsInterface).getClientName(), activity as OnPotreroListener)
        binding.buttonAddPotrero.setOnClickListener {
            (activity as AddPotreroInformationFragment.AddPotreroInterface).addPotreroClicked()
        }
    }

    override fun onPotreroClick() {
        (activity as OnPotreroListener).onPotreroClick()
    }

    override fun onPotreroLongClick(name: String) {
        (activity as OnPotreroListener).onPotreroLongClick(name)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            PotrerosFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}