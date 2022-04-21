package com.example.campoapp.presentation.mvp.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.campoapp.databinding.FragmentAddClientBinding

class AddClientFragment : Fragment() {

    interface NewClientListener {
        fun setNewClient(newClient: String)
        fun backStack()
    }
    private lateinit var binding: FragmentAddClientBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddClientBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.addNewClientButton.setOnClickListener {  (activity as NewClientListener).setNewClient(binding.newClientEditText.text.toString()) }
        binding.cancelNewClientButton.setOnClickListener { (activity as NewClientListener).backStack() }
    }

    companion object {
        @JvmStatic
        fun newInstance() = AddClientFragment()
    }
}