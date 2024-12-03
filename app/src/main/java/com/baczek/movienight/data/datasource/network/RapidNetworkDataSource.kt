package com.baczek.movienight.data.datasource.network

import com.baczek.movienight.data.model.asset.AssetResponse
import com.baczek.movienight.data.model.country.toList
import com.baczek.movienight.domain.model.country.Country
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RapidNetworkDataSource @Inject constructor(
    private val rapidApi: RapidApi,
) {

//    suspend fun fetchAsset(id: String): AssetResponse = rapidApi.fetchAsset(id)
//
//    suspend fun searchByTitle(phrase: String): List<AssetResponse> = rapidApi.searchByTitle(phrase)

    suspend fun fetchCountries(): List<Country> = rapidApi.fetchCountries().toList()
}