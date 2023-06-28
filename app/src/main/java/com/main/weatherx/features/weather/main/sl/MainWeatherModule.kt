package com.main.weatherx.features.weather.main.sl

import com.main.weatherx.core.sl.Core
import com.main.weatherx.core.sl.Module
import com.main.weatherx.features.weather.main.presentation.communication.CoordinatesCommunication
import com.main.weatherx.features.weather.main.presentation.communication.ErrorCommunication
import com.main.weatherx.features.weather.main.presentation.communication.GeoDataCommunication
import com.main.weatherx.features.weather.main.presentation.communication.LocationCommunication
import com.main.weatherx.features.weather.main.presentation.communication.MainWeatherCommunication
import com.main.weatherx.features.weather.main.presentation.communication.ProgressCommunication
import com.main.weatherx.features.weather.main.presentation.viewmodel.MainGeoViewModel
import com.main.weatherx.some.BaseGeoRepository
import com.main.weatherx.some.GeoResultMapper
import com.main.weatherx.some.GeoService
import com.main.weatherx.some.GetGeoDataFeature
import com.main.weatherx.some.GetGeoDataUseCase

class MainWeatherModule(
    private val core: Core
) : Module<MainGeoViewModel.Base> {
    override fun viewModel(): MainGeoViewModel.Base {
        val mainWeatherCommunication = MainWeatherCommunication.Base(
            locationCommunication = LocationCommunication.Base(),
            progressCommunication = ProgressCommunication.Base(),
            coordinatesCommunication = CoordinatesCommunication.Base(),
            geoDataCommunication = GeoDataCommunication.Base(),
            errorCommunication = ErrorCommunication.Base()
        )
        val geoRepository = BaseGeoRepository(core.service(GeoService::class.java))
        val getGeoDataUseCase = GetGeoDataUseCase(geoRepository)
        val getGeoDataFeature = GetGeoDataFeature.Base(
            useCase = getGeoDataUseCase,
            communication = mainWeatherCommunication,
            geoResultMapper = GeoResultMapper(mainWeatherCommunication)
        )
        return MainGeoViewModel.Base(
            communication = mainWeatherCommunication,
            getGeoDataFeature = getGeoDataFeature
        )
    }
}
