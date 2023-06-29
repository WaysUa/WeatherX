package com.main.weatherx.some.entities

import com.google.gson.annotations.SerializedName

data class Components(
    @SerializedName("ISO_3166-1_alpha-2") val ISO31661Alpha2: String,
    @SerializedName("ISO_3166-1_alpha-3") val ISO31661Alpha3: String,
    @SerializedName("ISO_3166-2") val ISO31662: List<String>,
    @SerializedName("_category") val category: String,
    @SerializedName("_type") val type: String,
    val continent: String,
    val country: String,
    @SerializedName("country_code") val countryCode: String,
    val district: String,
    val municipality: String,
    val postcode: String,
    val state: String,
    val village: String
)
