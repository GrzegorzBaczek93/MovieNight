package com.baczek.movienight.domain.model.asset

enum class AssetType {
    MOVIE,
    SHOW,
    SEASON,
    EPISODE;

    fun apiString() = this.name.lowercase()
}