package com.main.weatherx.some.entities

data class Currency(
    val alternate_symbols: List<Any>,
    val decimal_mark: String,
    val format: String,
    val html_entity: String,
    val iso_code: String,
    val iso_numeric: String,
    val name: String,
    val smallest_denomination: Int,
    val subunit: String,
    val subunit_to_unit: Int,
    val symbol: String,
    val symbol_first: Int,
    val thousands_separator: String
)
