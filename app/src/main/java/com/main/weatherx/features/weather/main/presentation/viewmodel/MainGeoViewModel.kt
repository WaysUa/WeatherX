package com.main.weatherx.features.weather.main.presentation.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.main.weatherx.core.data.BaseViewModel
import com.main.weatherx.features.weather.main.data.entities.Coordinates
import com.main.weatherx.features.weather.main.domain.feature.GetGeoDataFeature
import com.main.weatherx.features.weather.main.presentation.communication.FetchCoordinates
import com.main.weatherx.features.weather.main.presentation.communication.MainWeatherCommunication
import com.main.weatherx.features.weather.main.presentation.communication.ObserveMainWeatherStates
import com.main.weatherx.main.presentation.core.DispatchersList
import com.main.weatherx.some.entities.GeoData

interface MainGeoViewModel : ObserveMainWeatherStates {

    class Base(
        private val communication: MainWeatherCommunication,
        private val getGeoDataFeature: GetGeoDataFeature
    ) : BaseViewModel(DispatchersList.Base()), MainGeoViewModel, FetchCoordinates {

        override fun fetchCoordinates(coordinates: Coordinates) {
            communication.fetchCoordinates(coordinates)
            getGeoDataFeature.coordinates(communication.valueCoordinates()).handle(this)
        }

        override fun observeProgress(owner: LifecycleOwner, observer: Observer<Int>) {
            communication.observeProgress(owner, observer)
        }

        override fun observeGeoData(owner: LifecycleOwner, observer: Observer<GeoData>) {
            communication.observeGeoData(owner, observer)
        }

        override fun observeError(owner: LifecycleOwner, observer: Observer<String>) {
            communication.observeError(owner, observer)
        }
    }
}
