package com.example.campoapp.presentation.mvp.model

import com.example.campoapp.data.Client
import com.example.campoapp.domain.GetClientInformationUseCase
import com.example.campoapp.presentation.mvp.contract.ClientContract

class ClientModel(private var getClientInformationUseCase: GetClientInformationUseCase) : ClientContract.Model {

    private var clients: MutableList<Client> = mutableListOf()

    override fun createClientList(){
        clients = getClientInformationUseCase.getClients()
    }

    override fun getClients(): MutableList<Client> {
        return clients
    }

    override fun addClient(name: String) {
        clients.add(Client(name))
        getClientInformationUseCase.addClient(clients)
    }

    override fun deleteClient(name: String) {
        clients.removeIf { it.name == name }
    }

    override fun editClient(name: String, newName: String) {
        clients.forEach { if(it.name==name) it.name=newName }
    }
}
