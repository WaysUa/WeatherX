package com.main.weatherx.features.weather.main.domain

import com.main.weatherx.features.weather.main.data.GeoData

sealed class GeoResult {

    interface Mapper<T> {
        fun map(list: List<GeoData>): T
        fun map(errorMessage: String): T
    }

    abstract fun <T> map(mapper: Mapper<T>): T

    data class Success(private val list: List<GeoData> = emptyList()) : GeoResult() {
        override fun <T> map(mapper: Mapper<T>): T = mapper.map(list)
    }

    data class Failure(private val message: String) : GeoResult() {
        override fun <T> map(mapper: Mapper<T>): T = mapper.map(message)
    }
}
