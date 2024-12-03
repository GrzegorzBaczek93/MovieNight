package com.baczek.movienight.data.datasource.network

import com.baczek.movienight.data.client.httpClient
import com.baczek.movienight.data.model.asset.AssetResponse
import io.ktor.client.call.body
import io.ktor.client.request.forms.submitForm
import io.ktor.http.parameters
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AssetApi @Inject constructor() {

    suspend fun fetchAsset(id: String): AssetResponse = httpClient.submitForm(
        url = "/shows/${id}",
        formParameters = parameters {
            append("series_granularity", "show")
            append("output_language", "en")
        },
        encodeInQuery = true
    ).body()

    suspend fun searchByTitle(phrase: String): List<AssetResponse> = httpClient.submitForm(
        url = "/shows/search/title",
        formParameters = parameters {
            append("title", phrase)
            append("country", "pl")
        },
        encodeInQuery = true
    ).body()
}