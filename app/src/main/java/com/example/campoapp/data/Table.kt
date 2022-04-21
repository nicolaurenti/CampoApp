package com.example.campoapp.data

data class Table(
    var fooderResources: FodderResources,
    var observation: Observation?,
    var period: List<List<Double?>?>,
    var prom: List<Double?>,
    var rinde: List<Int?>
)
