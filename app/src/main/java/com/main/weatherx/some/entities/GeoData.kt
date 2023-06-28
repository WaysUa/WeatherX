package com.main.weatherx.some.entities

data class GeoData(
    val documentation: String,
    val licenses: List<License>,
    val rate: Rate,
    val results: List<Result>,
    val status: Status,
    val stay_informed: StayInformed,
    val thanks: String,
    val timestamp: Timestamp,
    val total_results: Int
)
