package com.example.campoapp.presentation.mvp.presenter

import com.example.campoapp.data.Potrero
import com.example.campoapp.presentation.listener.OnClientListener
import com.example.campoapp.presentation.mvp.contract.ClientContract

class ClientPresenter(private val model: ClientContract.Model,
                      private val view: ClientContract.View) : ClientContract.Presenter {

    override fun createClientList() {
        model.createClientList()
    }

    override fun onClientClick(clientName: String) {
        view.showClient(clientName)
    }

    override fun showClients(onClientListener: OnClientListener) {
        view.showClients(model.getClients(), onClientListener)
    }

    override fun addClient(name:String, onClientListener: OnClientListener) {
        model.addClient(name)
        view.showClients(model.getClients(), onClientListener)
    }

    override fun showDeleteClientButton() {
        view.showDeleteClientButton()
    }

    override fun showEditClientButton() {
        view.showEditClientButton()
    }

    override fun deleteClient(name: String) {
        model.deleteClient(name)
    }

    override fun hideDeleteClientButton() {
        view.hideDeleteClientButton()
    }

    override fun hideEditClientButton() {
        view.hideEditClientButton()
    }

    override fun editClient(name: String) {
        model.editClient(name, "Campo editado")
    }

    override fun showAddClient() {
        view.showAddClient()
    }

}
