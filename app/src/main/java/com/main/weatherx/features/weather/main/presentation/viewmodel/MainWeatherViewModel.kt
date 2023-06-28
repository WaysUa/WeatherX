package com.main.weatherx.features.weather.main.presentation.viewmodel

import com.main.weatherx.core.data.BaseViewModel
import com.main.weatherx.features.weather.main.presentation.communication.MainWeatherCommunication
import com.main.weatherx.main.presentation.core.DispatchersList
import com.main.weatherx.main.presentation.core.UiFeature

interface MainWeatherViewModel : FetchWeather {

    class Base(
        private val communication: MainWeatherCommunication,
        private val geoFeature: UiFeature
    ) : BaseViewModel(DispatchersList.Base()), MainWeatherViewModel {

        override fun fetchGeoData() {
            geoFeature.handle(this)
        }
    }
}

interface FetchWeather {

    fun fetchGeoData()
}
