package com.main.weatherx.features.weather.main.domain.repository

import com.main.weatherx.features.weather.main.data.entities.Coordinates
import com.main.weatherx.some.entities.GeoData

interface GeoRepository {
    suspend fun geoData(coordinates: Coordinates): GeoData
}
