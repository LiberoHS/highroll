package com.highroll.config

import com.fasterxml.jackson.annotation.JsonProperty
import com.highroll.util.ObjectMapperUtil.Companion.OBJECT_MAPPER
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.TimeUnit

data class AccessToken(
    @JsonProperty("access_token")
    val accessToken: String,
    @JsonProperty("token_type")
    val tokenType: String,
    val expires_in: String,
    @JsonProperty("sub")
    val clientId: String
)

@Configuration
class AccessTokenConfig {

    @Value("\${oauth.url}")
    private lateinit var oauthUrl: String

    companion object {
        val log = KotlinLogging.logger {}

        fun getAccessToken(): String = System.getProperty("API_ACCESS_TOKEN")
    }

    @Bean
    fun refreshAccessToken() {
        val clientId = System.getenv("API_CLIENT_ID")
        val clientSecret = System.getenv("API_CLIENT_SECRET")
        try {
            log.info { "Getting API access token from official Blizzard API OAuth" }
            val process = ProcessBuilder("curl", "-u", "$clientId:$clientSecret", "-d", "grant_type=client_credentials", "$oauthUrl/oauth/token").start()
            process.waitFor(10, TimeUnit.SECONDS)
            val response = process.inputStream.bufferedReader().readText()
            val accessToken: AccessToken = OBJECT_MAPPER.readValue(response, AccessToken::class.java)
            System.setProperty("API_ACCESS_TOKEN", accessToken.accessToken)
        } catch (e: Exception) {
            e.printStackTrace()
            return
        }
    }
}