package com.main.weatherx.some

import com.main.weatherx.features.weather.main.presentation.communication.MainWeatherCommunication

interface GetGeoDataFeature {

    fun coordinates(coordinates: Coordinates): UiFeature

    class Base(
        private val useCase: GetGeoDataUseCase,
        communication: MainWeatherCommunication,
        geoResultMapper: GeoResult.Mapper<Unit>
    ) : GeoFeature(communication, geoResultMapper), GetGeoDataFeature {

        // todo delete lateinit var
        private lateinit var coordinates: Coordinates

        override fun coordinates(coordinates: Coordinates): UiFeature {
            this.coordinates = coordinates
            return this
        }

        override suspend fun invoke(): GeoResult {
            return useCase.execute(coordinates)
        }
    }
}
