package com.main.weatherx.features.weather.main.domain.feature

import com.main.weatherx.features.weather.main.data.GeoResult
import com.main.weatherx.features.weather.main.data.entities.Coordinates
import com.main.weatherx.features.weather.main.domain.usecase.GetGeoDataUseCase
import com.main.weatherx.features.weather.main.presentation.communication.MainWeatherCommunication
import com.main.weatherx.main.presentation.core.UiFeature

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
