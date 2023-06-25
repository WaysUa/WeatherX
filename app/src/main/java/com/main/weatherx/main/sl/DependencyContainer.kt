package com.main.weatherx.main.sl

import androidx.lifecycle.ViewModel
import com.main.weatherx.core.sl.Core
import com.main.weatherx.core.sl.Module
import com.main.weatherx.main.presentation.viewmodel.MainViewModel

interface DependencyContainer {

    fun <T : ViewModel> module(clazz: Class<T>): Module<*>

    class Error : DependencyContainer {
        override fun <T : ViewModel> module(clazz: Class<T>): Module<*> {
            throw IllegalStateException("no module found for $clazz")
        }
    }

    class Base(
        private val core: Core,
        private val dependencyContainer: DependencyContainer = Error()
    ) : DependencyContainer {

        override fun <T : ViewModel> module(clazz: Class<T>): Module<*> = when (clazz) {
            MainViewModel::class.java -> MainModule()
            else -> dependencyContainer.module(clazz)
        }
    }
}
