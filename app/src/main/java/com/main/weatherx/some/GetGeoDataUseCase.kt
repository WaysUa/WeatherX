package com.main.weatherx.some

class GetGeoDataUseCase(
    private val geoRepository: GeoRepository
) {
    suspend fun execute(coordinates: Coordinates): GeoResult {
        return GeoResult.Success(geoRepository.geoData(coordinates))
    }
}
