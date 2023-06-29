package com.main.weatherx.features.weather.main.domain.feature

import android.view.View
import com.main.weatherx.core.data.Handle
import com.main.weatherx.features.weather.main.data.GeoResult
import com.main.weatherx.features.weather.main.presentation.communication.MainWeatherCommunication
import com.main.weatherx.main.presentation.core.UiFeature
import kotlinx.coroutines.Job

abstract class GeoFeature(
    private val communications: MainWeatherCommunication,
    private val geoResultMapper: GeoResult.Mapper<Unit>
) : UiFeature, suspend () -> GeoResult {

    override fun handle(handle: Handle): Job {
        communications.showProgress(View.VISIBLE)
        return handle.handle(this) { result ->
            communications.showProgress(View.GONE)
            showUi(result)
        }
    }

    protected fun showUi(result: GeoResult) = result.map(geoResultMapper)
}
