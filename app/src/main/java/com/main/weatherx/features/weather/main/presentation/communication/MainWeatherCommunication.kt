package com.main.weatherx.features.weather.main.presentation.communication

import android.location.Location
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.main.weatherx.main.presentation.communication.Communication

interface MainWeatherCommunication : ObserveMainWeatherStates {

    fun mapLocation(location: Location)

    fun showProgress(show: Int)

    class Base(
        private val mainWeatherLocationCommunication: MainWeatherLocationCommunication,
        private val progressCommunication: ProgressCommunication
    ) : MainWeatherCommunication {
        override fun mapLocation(location: Location) {
            mainWeatherLocationCommunication.map(location)
        }

        override fun showProgress(show: Int) {
            progressCommunication.map(show)
        }

        override fun observeLocation(owner: LifecycleOwner, observer: Observer<Location>) {
            mainWeatherLocationCommunication.observe(owner, observer)
        }

        override fun observeProgress(owner: LifecycleOwner, observer: Observer<Int>) {
            progressCommunication.observe(owner, observer)
        }
    }
}

interface ObserveMainWeatherStates {

    fun observeLocation(owner: LifecycleOwner, observer: Observer<Location>)

    fun observeProgress(owner: LifecycleOwner, observer: Observer<Int>)
}

interface MainWeatherLocationCommunication : Communication.Mutable<Location> {
    class Base : Communication.Ui<Location>(), MainWeatherLocationCommunication
}

interface ProgressCommunication : Communication.Mutable<Int> {
    class Base : Communication.Ui<Int>(), ProgressCommunication
}
