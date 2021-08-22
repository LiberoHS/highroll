package com.highroll.client

import com.highroll.TestData.HEARTHSTONE_CARD_SEARCH
import com.highroll.TestData.PARAMS
import com.highroll.model.HearthstoneCardResult
import io.mockk.*
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@ExtendWith(SpringExtension::class)
class BlizzardClientTest {

    @InjectMockKs
    private lateinit var blizzardClient: BlizzardClient

    private val blizzardUrl = "http://blizzard.com"

    @BeforeEach
    fun setup() {
        blizzardClient = BlizzardClient(blizzardUrl)
    }

    @Test
    fun `client can return a valid result of cards`() {
        val urlSlot = slot<String>()
        val webClient = mockk<WebClient>()
        every { webClient.get()
            .uri(capture(urlSlot))
            .header(any(), any())
            .accept(any())
            .retrieve()
            .bodyToMono(HearthstoneCardResult::class.java)
        } returns Mono.just(HEARTHSTONE_CARD_SEARCH)

        assertThat(blizzardClient.getCardQuery(PARAMS, 0)).isEqualTo(HEARTHSTONE_CARD_SEARCH)
        verify (exactly = 1) { webClient.get().uri(capture(urlSlot)).header(any(), any()).accept(any()).retrieve() }
        confirmVerified(webClient)
    }
}