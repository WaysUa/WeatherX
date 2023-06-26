package com.main.weatherx.main.presentation.navigation

import com.main.notelink.core.data.BaseFragment
import com.main.weatherx.features.weather.main.presentation.ui.MainWeatherFragment

sealed class Screen {

    abstract fun fragment(): Class<out BaseFragment<*>>

    object MainWeather : Screen() {
        override fun fragment(): Class<out BaseFragment<*>> = MainWeatherFragment::class.java
    }
}
