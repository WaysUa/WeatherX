package com.main.weatherx.some.entities

data class Annotations(
    val DMS: DMS,
    val MGRS: String,
    val Maidenhead: String,
    val Mercator: Mercator,
    val OSM: OSM,
    val UN_M49: UNM49,
    val callingcode: Int,
    val currency: Currency,
    val flag: String,
    val geohash: String,
    val qibla: Double,
    val roadinfo: Roadinfo,
    val sun: Sun,
    val timezone: Timezone,
    val what3words: What3words
)
