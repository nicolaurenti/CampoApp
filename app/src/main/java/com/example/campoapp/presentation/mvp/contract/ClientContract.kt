package com.example.campoapp.presentation.mvp.contract

import com.example.campoapp.data.Client
import com.example.campoapp.data.Potrero
import com.example.campoapp.presentation.listener.OnClientListener

interface ClientContract {
    interface Model {
        fun addClient(name: String)
        fun deleteClient(name: String)
        fun editClient(name: String, newName: String)
        fun getClients(): MutableList<Client>
        fun createClientList()
    }

    interface View {
        fun showClients(clients: MutableList<Client>, onClientListener: OnClientListener)
        fun showClient(clientName: String)
        fun showDeleteClientButton()
        fun showEditClientButton()
        fun hideDeleteClientButton()
        fun hideEditClientButton()
        fun showAddClient()
    }

    interface Presenter {
        fun createClientList()
        fun onClientClick(clientName: String)
        fun showClients(onClientListener: OnClientListener)
        fun addClient(name: String, onClientListener: OnClientListener)
        fun showDeleteClientButton()
        fun showEditClientButton()
        fun deleteClient(name: String)
        fun hideDeleteClientButton()
        fun hideEditClientButton()
        fun editClient(name: String)
        fun showAddClient()
    }
}
