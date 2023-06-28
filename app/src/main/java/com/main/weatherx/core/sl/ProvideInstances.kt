package com.main.weatherx.core.sl

import android.content.Context
import com.main.weatherx.datasource.sl.GeoCloudModule

interface ProvideInstances {

    fun provideCloudModule(): GeoCloudModule

    class Release(private val context: Context) : ProvideInstances {
        override fun provideCloudModule(): GeoCloudModule {
            return GeoCloudModule.Base()
        }
    }
}
