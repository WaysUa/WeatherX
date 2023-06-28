package com.main.weatherx.core.sl

import com.main.weatherx.datasource.sl.GeoCloudModule
import com.main.weatherx.main.presentation.core.DispatchersList
import com.main.weatherx.main.presentation.navigation.NavigationCommunication

interface Core : GeoCloudModule, ProvideNavigation {

    fun provideDispatchers(): DispatchersList

    class Base : Core {

        private val navigationCommunication = NavigationCommunication.Base()

        private val dispatchersList by lazy {
            DispatchersList.Base()
        }

        override fun provideDispatchers() = dispatchersList
        override fun provideNavigation() = navigationCommunication
    }
}

interface ProvideNavigation {
    fun provideNavigation(): NavigationCommunication.Mutable
}
