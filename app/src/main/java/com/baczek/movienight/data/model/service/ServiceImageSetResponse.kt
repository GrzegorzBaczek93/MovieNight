package com.baczek.movienight.data.model.service

import com.baczek.movienight.domain.model.service.ServiceImageSet
import kotlinx.serialization.Serializable

@Serializable
data class ServiceImageSetResponse(
    val lightThemeImage: String,
    val darkThemeImage: String,
)

fun ServiceImageSetResponse.toServiceImageSet() = ServiceImageSet(
    lightThemeImage = lightThemeImage,
    darkThemeImage = darkThemeImage
)
