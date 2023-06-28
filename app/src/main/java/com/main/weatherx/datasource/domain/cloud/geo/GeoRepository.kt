package com.main.weatherx.datasource.domain.cloud.geo

interface GeoRepository {

    fun getAddressByCoordinates(coordinates: String): String // todo geo data
}
