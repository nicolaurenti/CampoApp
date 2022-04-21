package com.example.campoapp.presentation.mvp.view.views

import android.app.Activity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.campoapp.data.Potrero
import com.example.campoapp.databinding.FragmentClientInformationBinding
import com.example.campoapp.presentation.adapter.PotreroAdapter
import com.example.campoapp.presentation.listener.OnPotreroListener
import com.example.campoapp.presentation.mvp.contract.ClientInformationContract
import com.example.campoapp.presentation.mvp.view.ActivityView

class ClientInformationView(
    activity: Activity,
    private val binding: FragmentClientInformationBinding
) : ClientInformationContract.View, ActivityView(activity) {

}