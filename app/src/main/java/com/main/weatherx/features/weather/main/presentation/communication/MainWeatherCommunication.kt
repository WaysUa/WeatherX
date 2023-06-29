package com.main.weatherx.features.weather.main.presentation.communication

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.main.weatherx.features.weather.main.data.entities.Coordinates
import com.main.weatherx.main.presentation.communication.Communication
import com.main.weatherx.some.entities.GeoData

interface MainWeatherCommunication : ObserveMainWeatherStates {

    fun mapGeoData(geoData: GeoData)

    fun mapError(message: String)

    fun showProgress(show: Int)

    class Base(
        private val progressCommunication: ProgressCommunication,
        private val coordinatesCommunication: CoordinatesCommunication,
        private val geoDataCommunication: GeoDataCommunication,
        private val errorCommunication: ErrorCommunication
    ) : MainWeatherCommunication {

        override fun mapGeoData(geoData: GeoData) {
            geoDataCommunication.map(geoData)
        }

        override fun mapError(message: String) {
            errorCommunication.map(message)
        }

        override fun showProgress(show: Int) {
            progressCommunication.map(show)
        }

        override fun observeProgress(owner: LifecycleOwner, observer: Observer<Int>) {
            progressCommunication.observe(owner, observer)
        }

        override fun observeGeoData(owner: LifecycleOwner, observer: Observer<GeoData>) {
            geoDataCommunication.observe(owner, observer)
        }

        override fun observeError(owner: LifecycleOwner, observer: Observer<String>) {
            errorCommunication.observe(owner, observer)
        }
    }
}

interface ObserveMainWeatherStates {

    fun observeProgress(owner: LifecycleOwner, observer: Observer<Int>)

    fun observeGeoData(owner: LifecycleOwner, observer: Observer<GeoData>)

    fun observeError(owner: LifecycleOwner, observer: Observer<String>)
}

interface GeoDataCommunication : Communication.Mutable<GeoData> {
    class Base : Communication.Ui<GeoData>(), GeoDataCommunication
}

interface ErrorCommunication : Communication.Mutable<String> {
    class Base : Communication.Ui<String>(), ErrorCommunication
}

interface ProgressCommunication : Communication.Mutable<Int> {
    class Base : Communication.Ui<Int>(), ProgressCommunication
}

interface CoordinatesCommunication : Communication.Mutable<Coordinates> {
    class Base : Communication.Ui<Coordinates>(), CoordinatesCommunication
}
