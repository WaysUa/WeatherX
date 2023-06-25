package com.main.weatherx.core.sl

import com.main.weatherx.main.sl.CloudModule

interface ProvideInstances {

    fun provideCloudModule(): CloudModule

//    class Release(private val context: Context) : ProvideInstances {
//        override fun provideCacheModule() = CloudModule.Base(context)
//    }
//
//    class Mock(private val context: Context) : ProvideInstances {
//        override fun provideCacheModule() = CloudModule.Mock(context)
//    }
}
