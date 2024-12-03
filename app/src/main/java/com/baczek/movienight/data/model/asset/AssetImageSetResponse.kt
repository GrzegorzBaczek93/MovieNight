package com.baczek.movienight.data.model.asset

import kotlinx.serialization.Serializable

@Serializable
data class AssetImageSetResponse(
    val verticalPoster: AssetImageSetVerticalResponse,
    val horizontalPoster: AssetImageSetHorizontalResponse,
    val verticalBackdrop: AssetImageSetVerticalResponse?,
    val horizontalBackdrop: AssetImageSetHorizontalResponse?,
)
