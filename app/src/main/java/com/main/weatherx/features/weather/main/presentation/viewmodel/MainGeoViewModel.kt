package com.main.weatherx.features.weather.main.presentation.viewmodel

import com.main.weatherx.core.data.BaseViewModel
import com.main.weatherx.features.weather.main.presentation.communication.MainWeatherCommunication
import com.main.weatherx.main.presentation.core.DispatchersList

interface MainGeoViewModel {

    class Base(
        private val communication: MainWeatherCommunication,
    ) : BaseViewModel(DispatchersList.Base()), MainGeoViewModel
}