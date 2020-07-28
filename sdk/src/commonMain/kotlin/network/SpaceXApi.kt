package com.jetbrains.handson.kmm.sdk.network

import com.jetbrains.handson.kmm.sdk.entity.RocketLaunch
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

class SpaceXApi {
    private val httpClient = HttpClient {
        install(JsonFeature) {
            val json = Json(JsonConfiguration(ignoreUnknownKeys = true))
            serializer = KotlinxSerializer(json)
        }
    }

    suspend fun getAllLaunches(): List<RocketLaunch> {
        return httpClient.get(LAUNCHES_ENDPOINT)
    }

    companion object {
        private const val LAUNCHES_ENDPOINT = "https://api.spacexdata.com/v3/launches"
    }
}