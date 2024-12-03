package com.baczek.movienight.domain.model.country

import com.baczek.movienight.domain.model.service.Service

data class Country(
    val countryCode: String,
    val name: String,
    val services: List<Service>,
)
