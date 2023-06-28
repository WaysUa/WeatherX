package com.main.weatherx.some

import com.main.weatherx.some.entities.GeoData

sealed class GeoResult {

    interface Mapper<T> {
        fun map(geoData: GeoData): T
        fun map(errorMessage: String): T
    }

    abstract fun <T> map(mapper: Mapper<T>): T

    data class Success(private val geoData: GeoData) : GeoResult() {
        override fun <T> map(mapper: Mapper<T>): T = mapper.map(geoData)
    }

    data class Failure(private val message: String) : GeoResult() {
        override fun <T> map(mapper: Mapper<T>): T = mapper.map(message)
    }
}
