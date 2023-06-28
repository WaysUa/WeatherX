package com.main.weatherx.some.entities

data class Timezone(
    val name: String,
    val now_in_dst: Int,
    val offset_sec: Int,
    val offset_string: String,
    val short_name: String
)
