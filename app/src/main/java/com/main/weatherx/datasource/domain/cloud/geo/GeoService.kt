package com.main.weatherx.datasource.domain.cloud.geo

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GeoService {

    @GET("/v1/json?")
    fun getAddressByCoordinates(
        @Query("q") coordinates: String,
        @Query("key") key: String
    ): Response<String>

    companion object {
        const val BASE_GEO_SERVICE_URL = "https://api.opencagedata.com/geocode"
    }
}
