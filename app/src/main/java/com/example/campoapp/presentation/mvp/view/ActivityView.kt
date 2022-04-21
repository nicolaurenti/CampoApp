package com.example.campoapp.presentation.mvp.view

import android.app.Activity
import android.content.Context
import java.lang.ref.WeakReference

open class ActivityView(activity: Activity) {
    private val activityRef: WeakReference<Activity> = WeakReference(activity)
    private val activity: Activity?
        get() = activityRef.get()
    val context: Context?
        get() = activity
}
