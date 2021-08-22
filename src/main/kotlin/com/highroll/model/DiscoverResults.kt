package com.highroll.model

data class DiscoverResults(
    var total: Int = 0,
    var results: List<Card> = listOf()
) {
    fun addResults(newList: List<Card>) {
        results += newList
        total = results.size
    }
}