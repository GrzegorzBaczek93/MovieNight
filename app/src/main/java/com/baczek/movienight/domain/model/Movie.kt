package com.baczek.movienight.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val description: String,
    val image: String,
    val rating: Int,
    val watched: Boolean,
)

private val mockedMovies = List(size = 10) {
    Movie(
        id = it,
        title = "Mocked movie #$it",
        description = "Mocked movie description #$it",
        image = "https://musicart.xboxlive.com/7/e28e1100-0000-0000-0000-000000000002/504/image.jpg?w=1920&h=1080",
        rating = it % 5,
        watched = it % 2 == 0,
    )
}


fun generateMockedMovies() = mockedMovies

fun getMovie(index: Int) = mockedMovies.getOrNull(index)
