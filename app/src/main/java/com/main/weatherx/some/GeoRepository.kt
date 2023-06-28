package com.main.weatherx.some

import com.main.weatherx.some.entities.GeoData

interface GeoRepository {
    suspend fun geoData(coordinates: Coordinates): GeoData
}
