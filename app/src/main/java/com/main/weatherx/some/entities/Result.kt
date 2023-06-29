package com.main.weatherx.some.entities

data class Result(
    val annotations: Annotations,
    val bounds: Bounds,
    val components: Components,
    val confidence: Int,
    val formatted: String,
    val geometry: Geometry
)
