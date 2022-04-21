package com.example.campoapp.presentation.mvp.view

import android.app.Activity
import android.content.Context
import androidx.fragment.app.FragmentActivity
import java.lang.ref.WeakReference

open class FragmentView(activity: FragmentActivity?) {
    private val activityRef: WeakReference<Activity> = WeakReference(activity)
    private val activity: Activity?
        get() = activityRef.get()
    val context: Context?
        get() = activity
}