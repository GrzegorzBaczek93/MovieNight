package com.baczek.movienight.data.client

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.header
import io.ktor.http.URLProtocol
import io.ktor.http.headers
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

val httpClient = HttpClient(Android) {
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            ignoreUnknownKeys = true
            null
        })
    }

    install(Logging) {
        logger = Logger.SIMPLE
        level = LogLevel.HEADERS
    }

    defaultRequest {
        url {
            protocol = URLProtocol.HTTPS
            host = "streaming-availability.p.rapidapi.com"
        }
        headers {
            header("x-rapidapi-host", "streaming-availability.p.rapidapi.com")
            header("x-rapidapi-key", "adddfb8750mshd39bc00790b1209p1caa1djsn61e2659c4b9c")
        }
    }
}