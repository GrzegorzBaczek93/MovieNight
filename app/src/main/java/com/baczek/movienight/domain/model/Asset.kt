package com.baczek.movienight.domain.model

data class Asset(
    val id: Int,
    val title: String,
    val description: String,
    val image: String,
    val rating: Int,
    val watched: Boolean,
)

private val mockedAssets = List(size = 10) {
    Asset(
        id = it,
        title = "Mocked asset #$it",
        description = "Mocked asset description #$it",
        image = "https://musicart.xboxlive.com/7/e28e1100-0000-0000-0000-000000000002/504/image.jpg?w=1920&h=1080",
        rating = it % 5,
        watched = it % 2 == 0,
    )
}


fun generateMockedAssets() = mockedAssets

fun getAsset(index: Int) = mockedAssets.getOrNull(index)
