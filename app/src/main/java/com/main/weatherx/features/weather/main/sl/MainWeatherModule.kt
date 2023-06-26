package com.main.weatherx.features.weather.main.sl

import com.main.weatherx.core.sl.Module
import com.main.weatherx.features.weather.main.presentation.viewmodel.MainWeatherViewModel

class MainWeatherModule : Module<MainWeatherViewModel.Base> {
    override fun viewModel(): MainWeatherViewModel.Base {
        return MainWeatherViewModel.Base()
    }
}