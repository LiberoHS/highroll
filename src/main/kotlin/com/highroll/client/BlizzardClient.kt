package com.highroll.client

import com.highroll.config.AccessTokenConfig
import com.highroll.model.HearthstoneCardResult
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.util.MultiValueMap
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriComponentsBuilder

@Component
class BlizzardClient(
    @Value("\${blizzard.url}") blizzardUrl: String
) {

    private val webClient = WebClient.create(blizzardUrl)

    fun getCardQuery(params: MultiValueMap<String, String>, pageNumber: Int): HearthstoneCardResult? {
        val ACCESS_TOKEN = AccessTokenConfig.getAccessToken()
        return webClient
            .get()
            .uri(
                UriComponentsBuilder
                    .fromPath("/hearthstone/cards")
                    .queryParam("locale", "en_US")
                    .queryParam("page", pageNumber.toString())
                    .queryParams(params)
                    .toUriString()
            )
            .header("Authorization", "Bearer $ACCESS_TOKEN")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(HearthstoneCardResult::class.java)
            .block()
    }
}