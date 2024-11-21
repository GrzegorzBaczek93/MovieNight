package com.baczek.movienight.data.model.asset

data class AssetResponse(
    val id: String,
    val showType: String,
    val title: String,
    val originalTitle: String,
    val overview: String,
    val rating: Int,
    val imageSet: AssetImageSetResponse,
)
