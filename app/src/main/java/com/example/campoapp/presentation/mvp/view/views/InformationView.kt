package com.example.campoapp.presentation.mvp.view.views

import android.app.Activity
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.campoapp.R
import com.example.campoapp.presentation.mvp.view.activities.InformationActivity
import com.example.campoapp.databinding.ActivityInformationBinding
import com.example.campoapp.presentation.mvp.contract.InformationContract
import com.example.campoapp.presentation.mvp.view.ActivityView

class InformationView(
    activity: Activity,
    private val binding: ActivityInformationBinding
) : InformationContract.View, ActivityView(activity) {

    override fun showFragment(fragment: Fragment, tag: String) {
        (context as InformationActivity).supportFragmentManager.beginTransaction().add(
            binding.clientInformationFrameLayout.id, fragment, tag
        ).commit()
    }

    override fun showAnnualEstimate(annualEstimate: Int) {
        Toast.makeText(
            context,
            context?.resources?.getString(
                R.string.annual_estimate_text,
                annualEstimate.toString()
            ),
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun setClientName(client: String) {
        binding.fieldTitleTextView.text = client
    }

}
