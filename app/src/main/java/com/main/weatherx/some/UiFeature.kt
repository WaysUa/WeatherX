package com.main.weatherx.some

import com.main.weatherx.core.data.Handle
import kotlinx.coroutines.Job

interface UiFeature {

    fun handle(handle: Handle): Job
}
