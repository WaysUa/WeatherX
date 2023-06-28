package com.main.weatherx.datasource.sl

interface GeoCloudModule {

    fun <T> service(clazz: Class<T>): T

    class Base : GeoCloudModule {
        override fun <T> service(clazz: Class<T>): T {
            TODO("Not yet implemented")
        }
    }
}
