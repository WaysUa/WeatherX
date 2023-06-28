package com.main.weatherx.features.weather.main.presentation.communication

import android.location.Location
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.main.weatherx.main.presentation.communication.Communication
import com.main.weatherx.some.Coordinates
import com.main.weatherx.some.entities.GeoData
import java.lang.IllegalStateException

interface MainWeatherCommunication :
    ObserveMainWeatherStates,
    FetchCoordinates,
    ValueCoordinates,
    MapMainWeatherStates {

    fun mapGeoData(geoData: GeoData)

    fun mapError(message: String)

    fun showProgress(show: Int)

    class Base(
        private val locationCommunication: LocationCommunication,
        private val progressCommunication: ProgressCommunication,
        private val coordinatesCommunication: CoordinatesCommunication,
        private val geoDataCommunication: GeoDataCommunication,
        private val errorCommunication: ErrorCommunication
    ) : MainWeatherCommunication {

        override fun mapLocation(location: Location) {
            locationCommunication.map(location)
        }

        override fun mapGeoData(geoData: GeoData) {
            geoDataCommunication.map(geoData)
        }

        override fun mapError(message: String) {
            errorCommunication.map(message)
        }

        override fun showProgress(show: Int) {
            progressCommunication.map(show)
        }

        override fun observeLocation(owner: LifecycleOwner, observer: Observer<Location>) {
            locationCommunication.observe(owner, observer)
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

        override fun fetchCoordinates(coordinates: Coordinates) {
            coordinatesCommunication.map(coordinates)
        }

        override fun valueCoordinates(): Coordinates {
            return coordinatesCommunication.value() ?: throw IllegalStateException(
                "MainWeatherCommunication: error"
            )
        }
    }
}

interface MapMainWeatherStates {

    fun mapLocation(location: Location)
}

interface FetchCoordinates {
    fun fetchCoordinates(coordinates: Coordinates)
}

interface ValueCoordinates {
    fun valueCoordinates(): Coordinates
}

interface ObserveMainWeatherStates {

    fun observeLocation(owner: LifecycleOwner, observer: Observer<Location>)

    fun observeProgress(owner: LifecycleOwner, observer: Observer<Int>)

    fun observeGeoData(owner: LifecycleOwner, observer: Observer<GeoData>)

    fun observeError(owner: LifecycleOwner, observer: Observer<String>)
}

interface LocationCommunication : Communication.Mutable<Location> {
    class Base : Communication.Ui<Location>(), LocationCommunication
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
