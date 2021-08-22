package com.highroll

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.highroll.model.HearthstoneCardResult
import com.highroll.util.JsonReaderUtil.Companion.loadResourceJsonIntoObject
import org.springframework.util.CollectionUtils
import org.springframework.util.MultiValueMap

object TestData {
    val HEARTHSTONE_CARD_SEARCH = loadResourceJsonIntoObject(
        "/json/hearthstone-card-search.json",
        HearthstoneCardResult::class.java
    )

    val PARAMS: MultiValueMap<String, String> = CollectionUtils.toMultiValueMap(mapOf())
}