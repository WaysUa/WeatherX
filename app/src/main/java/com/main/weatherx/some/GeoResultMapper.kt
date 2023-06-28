package com.main.weatherx.some

import com.main.weatherx.features.weather.main.presentation.communication.MainWeatherCommunication
import com.main.weatherx.some.entities.GeoData

class GeoResultMapper(
    private val communications: MainWeatherCommunication
) : GeoResult.Mapper<Unit> {

    override fun map(geoData: GeoData) {
        communications.mapGeoData(geoData)
    }

    override fun map(errorMessage: String) {
        communications.mapError(errorMessage)
    }
}
