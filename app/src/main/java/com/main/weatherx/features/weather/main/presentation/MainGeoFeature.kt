package com.main.weatherx.features.weather.main.presentation

import com.main.weatherx.core.data.Handle
import com.main.weatherx.features.weather.main.domain.GeoResult
import com.main.weatherx.main.presentation.core.UiFeature
import kotlinx.coroutines.Job

interface MainGeoFeature : UiFeature, suspend () -> GeoResult {

    class Base : MainGeoFeature {
        override fun handle(handle: Handle): Job {
            TODO("Not yet implemented")
        }

        override suspend fun invoke(): GeoResult {
            TODO("Not yet implemented")
        }
    }
}
