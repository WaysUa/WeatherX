package com.main.weatherx.main.app

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.main.weatherx.core.sl.Core
import com.main.weatherx.core.sl.ProvideInstances
import com.main.weatherx.core.sl.ProvideViewModel
import com.main.weatherx.core.sl.ViewModelsFactory
import com.main.weatherx.main.sl.DependencyContainer

class WeatherXApplication : Application(), ProvideViewModel {
    private lateinit var viewModelsFactory: ViewModelsFactory
    private lateinit var dependencyContainer: DependencyContainer.Base

    override fun onCreate() {
        super.onCreate()
        val provideInstances = ProvideInstances.Release(this)
        dependencyContainer = DependencyContainer.Base(Core.Base(provideInstances))
        viewModelsFactory = ViewModelsFactory(dependencyContainer)
    }

    override fun <T : ViewModel> provideViewModel(clazz: Class<T>, owner: ViewModelStoreOwner): T {
        return ViewModelProvider(owner, viewModelsFactory)[clazz]
    }
}
