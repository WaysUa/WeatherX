package com.main.weatherx.core.sl

import com.main.weatherx.main.presentation.core.DispatchersList
import com.main.weatherx.main.sl.CloudModule

interface Core : CloudModule {

    fun provideDispatchers(): DispatchersList

    class Base(
//        private val provideInstances: ProvideInstances
    ) : Core {

        private val dispatchersList by lazy {
            DispatchersList.Base()
        }

        override fun provideDispatchers() = dispatchersList
//
//        override fun provideDataBase() = cacheModule.provideDataBase()
    }
}
