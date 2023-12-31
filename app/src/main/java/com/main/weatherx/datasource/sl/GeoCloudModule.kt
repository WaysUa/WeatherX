package com.main.weatherx.datasource.sl

import com.main.weatherx.datasource.domain.cloud.GeoService
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface GeoCloudModule {

    fun <T> service(clazz: Class<T>): T

    class Base : GeoCloudModule {
        override fun <T> service(clazz: Class<T>): T {
            val interceptor = HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }
            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .readTimeout(1, TimeUnit.MINUTES)
                .build()
            val retrofit = Retrofit.Builder()
                .client(client)
                .baseUrl(GeoService.BASE_GEO_SERVICE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(clazz)
        }
    }
}
