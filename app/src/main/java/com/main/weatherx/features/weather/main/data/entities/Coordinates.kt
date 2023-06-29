package com.main.weatherx.features.weather.main.data.entities

data class Coordinates(
    val lat: Double,
    val lon: Double
) {
    fun mapToString(): String {
        return "$lat%2C$lon"
    }
}
