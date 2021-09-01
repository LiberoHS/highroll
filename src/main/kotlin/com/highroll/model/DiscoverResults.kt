package com.highroll.model

data class DiscoverResults(
    var total: Int = 0,
    var results: List<Card> = listOf()
) {
    fun addResults(newList: List<Card>) {
        results += newList
        total = results.size
    }

    fun cleanResultsData(query: String): DiscoverResults {
        return this.removeDuplicateCards()
            .removeItself(query)
    }

    // should not discover itself (aka query used)
    private fun removeItself(query: String): DiscoverResults {
        return this.copy(results = results.filter { it.name != query })
    }

    // should not have duplicate names
    private fun removeDuplicateCards(): DiscoverResults {
        return this.copy(results = results.distinctBy { it.name })
    }
}