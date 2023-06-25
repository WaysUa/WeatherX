package com.main.weatherx.main.sl

import com.main.weatherx.core.sl.Module
import com.main.weatherx.main.presentation.viewmodel.MainViewModel

class MainModule : Module<MainViewModel> {
    override fun viewModel(): MainViewModel {
        return MainViewModel()
    }
}