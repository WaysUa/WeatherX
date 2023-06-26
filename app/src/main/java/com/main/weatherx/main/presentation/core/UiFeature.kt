package com.main.weatherx.main.presentation.core

import com.main.weatherx.core.data.Handle
import kotlinx.coroutines.Job

interface UiFeature {

    fun handle(handle: Handle): Job
}
