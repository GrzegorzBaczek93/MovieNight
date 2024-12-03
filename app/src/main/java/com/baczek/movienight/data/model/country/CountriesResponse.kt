package com.baczek.movienight.data.model.country

import kotlinx.serialization.Serializable

@Serializable
data class CountriesResponse(
    val pl: CountryResponse,
    val gb: CountryResponse,
    val us: CountryResponse,
)

fun CountriesResponse.toList() = listOf(
    pl.toCountry(),
    gb.toCountry(),
    us.toCountry(),
)

