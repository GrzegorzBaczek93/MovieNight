package com.baczek.movienight.domain.repository

import com.baczek.movienight.data.datasource.network.AssetNetworkDataSource
import com.baczek.movienight.domain.model.Asset
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AssetRepository @Inject constructor(
    private val assetNetworkDataSource: AssetNetworkDataSource,
) {

    suspend fun getAsset(id: String): Asset {
        val response = assetNetworkDataSource.fetchAsset(id)

        return Asset.mock
    }
}