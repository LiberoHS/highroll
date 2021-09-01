package com.highroll.service

import com.highroll.client.BlizzardClient
import com.highroll.db.CardData
import com.highroll.exception.CardNotFoundException
import com.highroll.model.*
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.util.CollectionUtils
import org.springframework.util.MultiValueMap
import org.springframework.web.server.ResponseStatusException

@Service
class HearthstoneService(
    private val blizzardClient: BlizzardClient
) {
    companion object {
        val log = KotlinLogging.logger {}
    }

    fun getDiscoverableCards(cardQuery: String, deckClass: DeckClass): DiscoverResults {
        val cardData = CardData.getCardByName(cardQuery) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Card data not found")
        val searchParamsMap = buildSearchParameters(cardData.query.buildQuery(deckClass))
        log.info { "Querying Hearthstone API for card: $cardQuery, params: $searchParamsMap" }
        return queryPagination(searchParamsMap, cardQuery)
    }

    fun queryPagination(searchParamsMap: MultiValueMap<String, String>, cardQuery: String): DiscoverResults {
        val discoverResults = DiscoverResults()
        var pageNumber = 0
        do {
            val response = blizzardClient.getCardQuery(searchParamsMap, pageNumber) ?: throw CardNotFoundException(errorMessage = "Cannot find results in query")
            discoverResults.addResults(response.cards)
            pageNumber += 1
        } while (response.page <= response.pageCount)

        return cleanDataAfterApiQuery(discoverResults, cardQuery)
    }

    fun buildSearchParameters(params: Map<String, List<String>>): MultiValueMap<String, String> {
        return CollectionUtils.toMultiValueMap(params)
    }

    fun cleanDataAfterApiQuery(discoverResults: DiscoverResults, cardQuery: String): DiscoverResults {
        return discoverResults.cleanResultsData(cardQuery)
    }
}