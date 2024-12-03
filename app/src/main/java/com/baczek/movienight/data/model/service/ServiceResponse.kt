package com.baczek.movienight.data.model.service

import com.baczek.movienight.domain.model.service.Service
import kotlinx.serialization.Serializable

@Serializable
data class ServiceResponse(
    val id: String,
    val name: String,
    val homePage: String,
    val imageSet: ServiceImageSetResponse,
)

fun ServiceResponse.toService() = Service(
    id = id,
    name = name,
    homePage = homePage,
    imageSet = imageSet.toServiceImageSet()
)
