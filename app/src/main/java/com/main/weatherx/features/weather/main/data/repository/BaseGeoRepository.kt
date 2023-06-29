package com.main.weatherx.features.weather.main.data.repository

import com.main.weatherx.datasource.domain.cloud.GeoService
import com.main.weatherx.features.weather.main.data.entities.Coordinates
import com.main.weatherx.features.weather.main.domain.repository.GeoRepository
import com.main.weatherx.some.entities.GeoData

class BaseGeoRepository(
    private val geoService: GeoService
) : GeoRepository {

    override suspend fun geoData(coordinates: Coordinates): GeoData {
        val response = geoService.getGeoData(
            query = coordinates.mapToString(),
            "bab8e69963114b299fbff5097c3fdf11"
        )
        return response.body() ?: throw IllegalStateException("service unavailable")
    }
}
