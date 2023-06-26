package com.main.weatherx.main.sl

import com.main.weatherx.core.sl.Core
import com.main.weatherx.core.sl.Module
import com.main.weatherx.main.presentation.viewmodel.MainViewModel

class MainModule(private val core: Core) : Module<MainViewModel> {
    override fun viewModel(): MainViewModel {
        return MainViewModel(navigationCommunication = core.provideNavigation())
    }
}
