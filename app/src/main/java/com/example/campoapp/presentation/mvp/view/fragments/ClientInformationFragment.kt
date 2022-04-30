package com.example.campoapp.presentation.mvp.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.campoapp.R
import com.example.campoapp.databinding.FragmentClientInformationBinding


class ClientInformationFragment : Fragment() {

    private lateinit var binding: FragmentClientInformationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentClientInformationBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ClientInformationFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}