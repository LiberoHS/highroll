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

    fun getDiscoverableCards(cardName: String, deckClass: DeckClass): DiscoverResults {
        val cardData = CardData.getCardByName(cardName) ?: throw Exception("Card data not found")
        val searchParamsMap = buildSearchParameters(cardData.query.buildQuery(deckClass))
        log.info { "Querying Hearthstone API for card: $cardName, params: $searchParamsMap" }
        return queryPagination(searchParamsMap)
    }

    fun queryPagination(searchParamsMap: MultiValueMap<String, String>): DiscoverResults {
        val discoverResults = DiscoverResults()
        var pageNumber = 0
        do {
            val response = blizzardClient.getCardQuery(searchParamsMap, pageNumber) ?: throw Exception("Cannot find results in query")
            discoverResults.addResults(response.cards)
            pageNumber += 1
        } while (response.page <= response.pageCount)

        return discoverResults
    }

    fun buildSearchParameters(params: Map<String, List<String>>): MultiValueMap<String, String> {
        return CollectionUtils.toMultiValueMap(params)
    }
}