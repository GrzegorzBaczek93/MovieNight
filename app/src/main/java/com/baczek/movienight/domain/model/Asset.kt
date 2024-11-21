package com.baczek.movienight.domain.model

data class Asset(
    val id: Int,
    val title: String,
    val description: String,
    val image: String,
    val rating: Int,
    val watched: Boolean,
) {
    companion object {
        val mock = Asset(
            id = 0,
            title = "Mocked asset",
            description = "Mocked asset description",
            image = "https://m.media-amazon.com/images/M/MV5BYzE2ODQ0NmQtYmMxMS00MGRlLTgwOGEtYjRkN2FkYmZlN2JlXkEyXkFqcGc@._V1_.jpg",
            rating = 10,
            watched = false,
        )
        val empty = Asset(
            id = 0,
            title = "",
            description = "",
            image = "",
            rating = 0,
            watched = false
        )
    }
}
