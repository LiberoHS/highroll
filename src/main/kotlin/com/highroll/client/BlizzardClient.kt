package com.highroll.client

import com.highroll.model.HearthstoneCardResult
import com.highroll.model.QueryDecorator
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriComponentsBuilder

@Component
class BlizzardClient(
) {
    val webClient = WebClient.create("https://us.api.blizzard.com")

    fun getCardQuery(decorators: Set<QueryDecorator>): HearthstoneCardResult {
        return webClient
            .get()
            .uri(
                UriComponentsBuilder.fromPath("/hearthstone").toUriString()
            )
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(HearthstoneCardResult::class.java)
    }
}