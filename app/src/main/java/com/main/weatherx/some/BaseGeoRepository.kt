package com.main.weatherx.some

import com.main.weatherx.some.entities.GeoData

class BaseGeoRepository(
    private val geoService: GeoService
) : GeoRepository {

    override suspend fun geoData(coordinates: Coordinates): GeoData {
        val response = geoService.getGeoData(query = coordinates.toString(), "")
        return response.body() ?: throw IllegalStateException("service unavailable")
    }
}
