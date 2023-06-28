package com.main.weatherx.core.sl

import com.main.weatherx.datasource.sl.GeoCloudModule

interface ProvideInstances {

    fun provideCloudModule(): GeoCloudModule

//    class Release(private val context: Context) : ProvideInstances {
//        override fun provideCacheModule() = CloudModule.Base(context)
//    }
//
//    class Mock(private val context: Context) : ProvideInstances {
//        override fun provideCacheModule() = CloudModule.Mock(context)
//    }
}
