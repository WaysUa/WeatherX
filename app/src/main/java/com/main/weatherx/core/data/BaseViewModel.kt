package com.main.weatherx.core.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.main.weatherx.main.presentation.core.DispatchersList
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class BaseViewModel(
    private val dispatchersList: DispatchersList,
) : ViewModel(), Handle {

    override fun <T : Any> handle(
        block: suspend () -> T,
        ui: (T) -> Unit,
    ) = viewModelScope.launch(dispatchersList.io()) {
        val result = block.invoke()
        withContext(dispatchersList.ui()) {
            ui.invoke(result)
        }
    }
}

interface Handle {
    fun <T : Any> handle(
        block: suspend () -> T,
        ui: (T) -> Unit,
    ): Job
}
