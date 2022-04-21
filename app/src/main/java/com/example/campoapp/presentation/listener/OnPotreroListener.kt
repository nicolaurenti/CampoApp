package com.example.campoapp.presentation.listener

import com.example.campoapp.data.Potrero

interface OnPotreroListener {
    fun onPotreroClick()
    fun onPotreroLongClick(name: String)
}