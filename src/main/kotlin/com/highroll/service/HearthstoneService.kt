package com.highroll.service

import com.highroll.client.BlizzardClient
import com.highroll.db.CardData
import com.highroll.model.*
import mu.KotlinLogging
import org.springframework.stereotype.Service
import org.springframework.util.CollectionUtils
import org.springframework.util.MultiValueMap
import java.lang.Exception

@Service
class HearthstoneService(
    private val blizzardClient: BlizzardClient
) {
    companion object {
        val log = KotlinLogging.logger {}
    }

    fun getDiscoverableCards(cardName: String, deckClass: DeckClass): HearthstoneCardResult? {
        val cardData = CardData.getCardByName(cardName) ?: throw Exception("Not found")
        val searchParamsMap = buildSearchParameters(cardData.query.buildQuery(deckClass))
        log.info { "Querying Hearthstone API for card: $cardName, params: $searchParamsMap" }
        return blizzardClient.getCardQuery(searchParamsMap)
    }

    fun buildSearchParameters(params: Map<String, List<String>>): MultiValueMap<String, String> {
        return CollectionUtils.toMultiValueMap(params)
    }
}