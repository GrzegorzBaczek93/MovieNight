package com.baczek.movienight.data.model.asset

import kotlinx.serialization.Serializable

@Serializable
data class AssetImageSetVerticalResponse(
    val w240: String,
    val w360: String,
    val w480: String,
    val w600: String,
    val w720: String,
)
