package com.example.campoapp.domain

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.campoapp.data.Client
import com.example.campoapp.data.Potrero
import com.google.gson.Gson

class GetClientInformationUseCase(activity: FragmentActivity?) {

    private val storageClientInformation = activity?.getSharedPreferences(SHARED_CLIENT_INFORMATION, Context.MODE_PRIVATE)
    private val storageClients = activity?.getSharedPreferences(SHARED_CLIENT, Context.MODE_PRIVATE)
    private val gson = Gson()

    fun getClients(): MutableList<Client> {
        val mutableSet = storageClients?.getStringSet(CLIENT_LIST, null)
        val clientList = mutableListOf<Client>()
        mutableSet?.forEach {
                clientList.add(gson.fromJson(it, Client::class.java))
        }
        return clientList
    }

    fun addClient(clients: MutableList<Client>) {
        val clientMutableSet = mutableSetOf<String>()
        clients.forEach{
            clientMutableSet.add(gson.toJson(it))
        }
        storageClients?.edit()?.clear()?.apply()
        storageClients?.edit()?.putStringSet(CLIENT_LIST, clientMutableSet)?.apply()
    }

    fun addPotrero(potreros: MutableList<Potrero>) {
        val potrerosMutableSet = mutableSetOf<String>()
        potreros.forEach{
            potrerosMutableSet.add(gson.toJson(it))
        }
        storageClientInformation?.edit()?.clear()?.apply()
        storageClientInformation?.edit()?.putStringSet(CLIENT_INFORMATION_LIST, potrerosMutableSet)?.apply()
    }

    fun getPotreros(client: String):MutableList<Potrero> {
        val mutableSet = storageClientInformation?.getStringSet(CLIENT_INFORMATION_LIST, null)
        val potrerosList = mutableListOf<Potrero>()
        mutableSet?.forEach {
            val potrero = gson.fromJson(it, Potrero::class.java)
            if (potrero.client == client) {
                potrerosList.add(potrero)
            }
        }
        return potrerosList
    }

    companion object {
        const val SHARED_CLIENT = "SHARED_CLIENT"
        private const val SHARED_CLIENT_INFORMATION = "SHARED_CLIENT_INFORMATION"
        private const val CLIENT_LIST = "CLIENT_LIST"
        private const val CLIENT_INFORMATION_LIST = "CLIENT_LIST_INFORMATION"
    }
}