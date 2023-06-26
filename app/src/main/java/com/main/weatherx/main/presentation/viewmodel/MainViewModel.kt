package com.main.weatherx.main.presentation.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.main.weatherx.main.presentation.communication.Communication
import com.main.weatherx.main.presentation.core.Init
import com.main.weatherx.main.presentation.navigation.NavigationCommunication
import com.main.weatherx.main.presentation.navigation.NavigationStrategy
import com.main.weatherx.main.presentation.navigation.Screen

class MainViewModel(
    private val navigationCommunication: NavigationCommunication.Mutable
) : ViewModel(), Init, Communication.Observe<NavigationStrategy> {

    override fun init(isFirstRun: Boolean) {
        if (isFirstRun) {
            navigationCommunication.map(NavigationStrategy.Replace(Screen.MainWeather))
        }
    }

    override fun observe(owner: LifecycleOwner, observer: Observer<NavigationStrategy>) {
        navigationCommunication.observe(owner, observer)
    }
}
