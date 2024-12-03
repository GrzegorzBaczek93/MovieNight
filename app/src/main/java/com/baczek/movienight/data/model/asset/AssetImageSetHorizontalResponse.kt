package com.baczek.movienight.data.model.asset

import kotlinx.serialization.Serializable

@Serializable
data class AssetImageSetHorizontalResponse(
    val w360: String,
    val w480: String,
    val w720: String,
    val w1080: String,
    val w1440: String,
)
