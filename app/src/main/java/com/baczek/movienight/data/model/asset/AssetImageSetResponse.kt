package com.baczek.movienight.data.model.asset

data class AssetImageSetResponse(
    val verticalPoster: AssetImageResponse,
    val horizontalPoster: AssetImageResponse,
    val verticalBackdrop: AssetImageResponse?,
    val horizontalBackdrop: AssetImageResponse?,
)
