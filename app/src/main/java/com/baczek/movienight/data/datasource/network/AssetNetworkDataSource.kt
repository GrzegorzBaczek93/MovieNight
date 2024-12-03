package com.baczek.movienight.data.datasource.network

import com.baczek.movienight.data.model.asset.AssetResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AssetNetworkDataSource @Inject constructor(
    private val assetApi: AssetApi,
) {

    suspend fun fetchAsset(id: String): AssetResponse = assetApi.fetchAsset(id)

    suspend fun searchByTitle(phrase: String): List<AssetResponse> = assetApi.searchByTitle(phrase)
}