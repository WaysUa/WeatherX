package com.main.weatherx.features.weather.main.presentation.viewmodel

import com.main.weatherx.core.data.BaseViewModel
import com.main.weatherx.main.presentation.core.DispatchersList

interface MainWeatherViewModel {

    class Base : BaseViewModel(DispatchersList.Base()), MainWeatherViewModel
}
