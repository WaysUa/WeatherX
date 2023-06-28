package com.main.weatherx.some

import com.main.weatherx.some.entities.GeoData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GeoService {

    @GET("v1/json")
    fun getGeoData(
        @Query("q") query: String,
        @Query("key") ket: String = ""
    ): Response<GeoData>

    companion object {
        const val BASE_GEO_SERVICE_URL = "https://api.opencagedata.com/geocode/"
    }
}
