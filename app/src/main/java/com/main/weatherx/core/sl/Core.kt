package com.main.weatherx.core.sl

import com.main.weatherx.datasource.sl.GeoCloudModule
import com.main.weatherx.main.presentation.core.DispatchersList
import com.main.weatherx.main.presentation.navigation.NavigationCommunication

interface Core : GeoCloudModule, ProvideNavigation {

    fun provideDispatchers(): DispatchersList

    class Base(
        private val provideInstances: ProvideInstances
    ) : Core {

        private val navigationCommunication = NavigationCommunication.Base()

        private val dispatchersList by lazy {
            DispatchersList.Base()
        }

        private val cloudModule by lazy {
            provideInstances.provideCloudModule()
        }

        override fun provideDispatchers() = dispatchersList
        override fun <T> service(clazz: Class<T>) = cloudModule.service(clazz)

        override fun provideNavigation() = navigationCommunication
    }
}

interface ProvideNavigation {
    fun provideNavigation(): NavigationCommunication.Mutable
}
