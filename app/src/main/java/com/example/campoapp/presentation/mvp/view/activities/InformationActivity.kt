package com.example.campoapp.presentation.mvp.view.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.campoapp.data.Potrero
import com.example.campoapp.databinding.ActivityInformationBinding
import com.example.campoapp.domain.GetClientInformationUseCase
import com.example.campoapp.presentation.adapter.ClientInformationViewPagerAdapter
import com.example.campoapp.presentation.listener.OnPotreroListener
import com.example.campoapp.presentation.mvp.contract.InformationContract
import com.example.campoapp.presentation.mvp.model.InformationModel
import com.example.campoapp.presentation.mvp.presenter.InformationPresenter
import com.example.campoapp.presentation.mvp.view.fragments.AddPotreroInformationFragment
import com.example.campoapp.presentation.mvp.view.fragments.AnnualEstimateFragment
import com.example.campoapp.presentation.mvp.view.fragments.PotrerosFragment
import com.example.campoapp.presentation.mvp.view.views.InformationView

class InformationActivity : AppCompatActivity(), OnPotreroListener, AddPotreroInformationFragment.AddPotreroInterface,
    AnnualEstimateFragment.AnnualEstimateListener, PotrerosFragment.SetFragmentsInterface {

    private lateinit var binding: ActivityInformationBinding
    private lateinit var presenter: InformationContract.Presenter
    private val adapter by lazy {
        ClientInformationViewPagerAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intent?.getStringExtra(CAMPO_NAME)
        presenter = InformationPresenter(InformationModel(GetClientInformationUseCase(this)), InformationView(this, binding))
        presenter.setClientName(intent?.getStringExtra(CAMPO_NAME) ?: "sin nombre", this)
        binding.clientInformationViewPager.adapter = adapter
        /*
            }
            binding.estimacionAnual.setOnClickListener {
                presenter.showFragment(
                    AnnualEstimateFragment.newInstance(),
                    ANNUAL_ESTIMATE_TAG
                )
            }*/
    }

    override fun getClientName(): String = intent?.getStringExtra(CAMPO_NAME) ?: "sin nombre"
    override fun addPotreroClicked() {
        presenter.showFragment(AddPotreroInformationFragment.newInstance(), ADD_POTRERO_TAG)
    }

    override fun addPotrero(potrero: Potrero) {
        if (potrero.name.isNotEmpty()) {
            presenter.addPotrero(potrero, this)
            cancelButtonClicked()
            updateList(potrero)
        } else {
            Toast.makeText(this, "chango, ponele un nombre", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateList(potrero: Potrero) {
        val fragment = supportFragmentManager.findFragmentByTag("f1")
        if (fragment is PotrerosFragment) {
            fragment.updateList(potrero, this)
        }
    }

    override fun createEstimation(weather: String, acum: Int, animals: List<Int>) {
        presenter.showAnnualEstimate(weather, acum, animals)
    }

    override fun cancelButtonClicked() {
        supportFragmentManager.beginTransaction().remove(supportFragmentManager.fragments.last()).commit()
    }

    override fun onPotreroClick() {
        Toast.makeText(this, "in progress", Toast.LENGTH_SHORT).show()
    }

    override fun onPotreroLongClick(name: String) {
        Toast.makeText(this, "in progress", Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val CAMPO_NAME = "CAMPO_NAME"
        const val ADD_POTRERO_TAG = "ADD_POTRERO_TAG"
        fun launch(context: Context?, name: String) {
            Intent(context, InformationActivity::class.java).apply {
                putExtra(CAMPO_NAME, name)
                context?.startActivity(this)
            }
        }
    }
}