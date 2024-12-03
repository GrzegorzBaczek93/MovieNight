package com.baczek.movienight.data.model.asset

import kotlinx.serialization.Serializable

@Serializable
data class AssetResponse(
    val id: String,
    val showType: String,
    val title: String,
    val originalTitle: String,
    val overview: String,
    val rating: Int,
    val imageSet: AssetImageSetResponse,
)
