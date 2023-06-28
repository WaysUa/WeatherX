package com.main.weatherx.features.weather.main.presentation.viewmodel

import android.location.Location
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.main.weatherx.core.data.BaseViewModel
import com.main.weatherx.features.weather.main.presentation.communication.FetchCoordinates
import com.main.weatherx.features.weather.main.presentation.communication.MainWeatherCommunication
import com.main.weatherx.features.weather.main.presentation.communication.MapMainWeatherStates
import com.main.weatherx.features.weather.main.presentation.communication.ObserveMainWeatherStates
import com.main.weatherx.main.presentation.core.DispatchersList
import com.main.weatherx.some.Coordinates
import com.main.weatherx.some.GetGeoDataFeature
import com.main.weatherx.some.entities.GeoData

interface MainGeoViewModel : MapMainWeatherStates, ObserveMainWeatherStates {

    class Base(
        private val communication: MainWeatherCommunication,
        private val getGeoDataFeature: GetGeoDataFeature
    ) : BaseViewModel(DispatchersList.Base()), MainGeoViewModel, FetchCoordinates {

        override fun fetchCoordinates(coordinates: Coordinates) {
            getGeoDataFeature.coordinates(communication.valueCoordinates()).handle(this)
            communication.fetchCoordinates(coordinates)
        }

        override fun mapLocation(location: Location) {
            communication.mapLocation(location)
        }

        override fun observeLocation(owner: LifecycleOwner, observer: Observer<Location>) {
            communication.observeLocation(owner, observer)
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
