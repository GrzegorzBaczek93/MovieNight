package com.baczek.movienight.domain.repository

import com.baczek.movienight.data.datasource.network.RapidNetworkDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountryAndServiceRepository @Inject constructor(
    private val rapidNetworkDataSource: RapidNetworkDataSource,
) {
    suspend fun getCountries() = rapidNetworkDataSource.fetchCountries()
}