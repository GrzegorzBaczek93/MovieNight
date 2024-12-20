package com.baczek.movienight.domain.repository

import com.baczek.movienight.data.datasource.network.RapidNetworkDataSource
import com.baczek.movienight.domain.model.asset.Asset
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AssetRepository @Inject constructor(
    private val rapidNetworkDataSource: RapidNetworkDataSource,
) {

    suspend fun getAsset(id: String): Asset {
//        val response = rapidNetworkDataSource.fetchAsset(id)

        return Asset.mock
    }
}