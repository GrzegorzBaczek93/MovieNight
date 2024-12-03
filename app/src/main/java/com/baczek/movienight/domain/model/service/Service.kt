package com.baczek.movienight.domain.model.service

data class Service(
    val id: String,
    val name: String,
    val homePage: String,
    val imageSet: ServiceImageSet,
)