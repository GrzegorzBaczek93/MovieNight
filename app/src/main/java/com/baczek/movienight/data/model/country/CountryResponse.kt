package com.baczek.movienight.data.model.country

import com.baczek.movienight.data.model.service.ServiceResponse
import com.baczek.movienight.data.model.service.toService
import com.baczek.movienight.domain.model.country.Country
import kotlinx.serialization.Serializable

@Serializable
data class CountryResponse(
    val countryCode: String,
    val name: String,
    val services: List<ServiceResponse>,
)

fun CountryResponse.toCountry() = Country(
    countryCode = countryCode,
    name = name,
    services = services.map { it.toService() }
)
