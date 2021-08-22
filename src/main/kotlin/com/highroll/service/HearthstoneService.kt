package com.highroll.service

import com.highroll.client.BlizzardClient
import com.highroll.model.*
import com.highroll.util.QueryParams
import mu.KotlinLogging
import org.springframework.stereotype.Service
import org.springframework.util.CollectionUtils
import org.springframework.util.MultiValueMap

@Service
class HearthstoneService(
    private val blizzardClient: BlizzardClient
) {
    companion object {
        val log = KotlinLogging.logger {}
    }

    fun getDiscoverableCards(): HearthstoneCardResult? {
        /* val memes = ManaCostDec("3",
            MinionTypeDec("beast",
                StandardBaseQuery("minion", "all")
            )
        )
        val query = memes.buildQuery()
        val searchParamsMap = buildSearchParameters(query) */
        // return blizzardClient.getCardQuery(searchParamsMap)
        return null
    }

    fun buildSearchParameters(params: Map<String, List<String>>): MultiValueMap<String, String> {
        return CollectionUtils.toMultiValueMap(params)
    }
}