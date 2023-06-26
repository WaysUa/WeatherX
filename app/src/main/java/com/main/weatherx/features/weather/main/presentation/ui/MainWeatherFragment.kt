package com.main.weatherx.features.weather.main.presentation.ui

import android.os.Bundle
import android.view.View
import com.main.notelink.core.data.BaseFragment
import com.main.weatherx.databinding.FragmentMainWeatherBinding
import com.main.weatherx.features.weather.main.presentation.viewmodel.MainWeatherViewModel

class MainWeatherFragment : BaseFragment<MainWeatherViewModel.Base>() {

    override val viewModelClass = MainWeatherViewModel.Base::class.java
    override val binding by lazy { FragmentMainWeatherBinding.inflate(layoutInflater) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
