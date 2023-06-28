package com.main.weatherx.features.weather.main.sl

import com.main.weatherx.core.sl.Module
import com.main.weatherx.features.weather.main.presentation.communication.MainWeatherCommunication
import com.main.weatherx.features.weather.main.presentation.communication.MainWeatherLocationCommunication
import com.main.weatherx.features.weather.main.presentation.communication.ProgressCommunication
import com.main.weatherx.features.weather.main.presentation.viewmodel.MainGeoViewModel

class MainWeatherModule : Module<MainGeoViewModel.Base> {
    override fun viewModel(): MainGeoViewModel.Base {
        val mainWeatherCommunication = MainWeatherCommunication.Base(
            mainWeatherLocationCommunication = MainWeatherLocationCommunication.Base(),
            progressCommunication = ProgressCommunication.Base()
        )
        return MainGeoViewModel.Base(
            communication = mainWeatherCommunication
        )
    }
}
