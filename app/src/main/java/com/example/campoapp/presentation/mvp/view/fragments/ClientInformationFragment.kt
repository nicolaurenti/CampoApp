package com.example.campoapp.presentation.mvp.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.campoapp.R


class ClientInformationFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_client_information, container, false)
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