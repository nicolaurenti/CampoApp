package com.example.campoapp.presentation.mvp.view.views

import android.app.Activity
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.campoapp.presentation.mvp.view.activities.ClientActivity
import com.example.campoapp.presentation.mvp.view.activities.InformationActivity
import com.example.campoapp.data.Client
import com.example.campoapp.databinding.ActivityClientBinding
import com.example.campoapp.presentation.mvp.view.fragments.AddClientFragment
import com.example.campoapp.presentation.adapter.ClientAdapter
import com.example.campoapp.presentation.listener.OnClientListener
import com.example.campoapp.presentation.mvp.contract.ClientContract
import com.example.campoapp.presentation.mvp.view.ActivityView

class ClientView(
    activity: Activity,
    private val binding: ActivityClientBinding
) :
    ClientContract.View, ActivityView(activity) {
    override fun showClients(clients: MutableList<Client>, onClientListener: OnClientListener) {
        binding.recyclerClients.layoutManager = LinearLayoutManager(context)
        binding.recyclerClients.adapter = ClientAdapter(clients, onClientListener)
    }

    override fun showClient(clientName: String) {
        InformationActivity.launch(context, clientName)
    }

    override fun showDeleteClientButton() {
        binding.buttonDeleteClient.visibility = View.VISIBLE
    }

    override fun showEditClientButton() {
        binding.buttonEditClient.visibility = View.VISIBLE
    }

    override fun hideDeleteClientButton() {
        binding.buttonDeleteClient.visibility = View.GONE
    }

    override fun hideEditClientButton() {
        binding.buttonEditClient.visibility = View.GONE
    }

    override fun showAddClient() {
        (context as ClientActivity).supportFragmentManager.beginTransaction().add(
            binding.newClientFrameLayout.id, AddClientFragment.newInstance(),
            ClientActivity.ADD_CLIENT_TAG
        ).commit()
    }

}
