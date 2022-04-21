package com.example.campoapp.presentation.mvp.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.campoapp.R
import com.example.campoapp.databinding.ActivityClientBinding
import com.example.campoapp.domain.GetClientInformationUseCase
import com.example.campoapp.presentation.mvp.view.fragments.AddClientFragment
import com.example.campoapp.presentation.listener.OnClientListener
import com.example.campoapp.presentation.mvp.contract.ClientContract
import com.example.campoapp.presentation.mvp.model.ClientModel
import com.example.campoapp.presentation.mvp.presenter.ClientPresenter
import com.example.campoapp.presentation.mvp.view.views.ClientView

class ClientActivity : AppCompatActivity(), OnClientListener, AddClientFragment.NewClientListener {

    private lateinit var presenter: ClientContract.Presenter
    private lateinit var binding: ActivityClientBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        Thread.sleep(2500)
        super.onCreate(savedInstanceState)
        binding = ActivityClientBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = ClientPresenter(ClientModel(GetClientInformationUseCase(this)), ClientView(this, binding))
        presenter.createClientList()
        presenter.showClients(this)
        binding.buttonAddClient.setOnClickListener {
            presenter.showAddClient()
        }
    }

    override fun onClientClick(clientName: String) {
        presenter.onClientClick(clientName)
    }


    override fun onClientLongClick(name: String) {
        presenter.showDeleteClientButton()
        presenter.showEditClientButton()
        binding.buttonDeleteClient.setOnClickListener {
            presenter.deleteClient(name)
            presenter.showClients(this)
            presenter.hideDeleteClientButton()
            presenter.hideEditClientButton()
        }
        binding.buttonEditClient.setOnClickListener {
            presenter.editClient(name)
            presenter.showClients(this)
            presenter.hideDeleteClientButton()
            presenter.hideEditClientButton()
        }
    }

    override fun setNewClient(newClient: String) {
        presenter.addClient(newClient, this)
        backStack()
    }

    override fun backStack() {
        val newClientFragment = supportFragmentManager.findFragmentByTag(ADD_CLIENT_TAG)
        if (newClientFragment is AddClientFragment)
        supportFragmentManager.beginTransaction().remove(newClientFragment).commit()
    }

    companion object {
        const val ADD_CLIENT_TAG = "ADD_CLIENT_TAG"
    }
}
