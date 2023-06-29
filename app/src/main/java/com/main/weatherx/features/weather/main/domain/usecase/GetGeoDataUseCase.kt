package com.main.weatherx.features.weather.main.domain.usecase

import com.main.weatherx.features.weather.main.data.GeoResult
import com.main.weatherx.features.weather.main.data.entities.Coordinates
import com.main.weatherx.features.weather.main.domain.repository.GeoRepository

class GetGeoDataUseCase(
    private val geoRepository: GeoRepository
) {
    suspend fun execute(coordinates: Coordinates): GeoResult {
        return GeoResult.Success(geoRepository.geoData(coordinates))
    }
}
