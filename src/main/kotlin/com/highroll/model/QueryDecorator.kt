package com.highroll.model

/* enum class QueryDecorator {
    MANA_COST(),
    KEYWORD(),
    MINION_TYPE(),
    RARITY(),
    TEXT_FILTER();
} */

abstract class QueryDecorator(
    open val key: String,
    open val attr: String
) {
    fun getQueryKey(): String {
        return key
    }

    fun getQueryAttribute(): String {
        return attr
    }

    open fun addParamToMap(map: MutableMap<String, List<String>>): MutableMap<String, List<String>> {
        map[key] = listOf(attr)
        return map
    }

    abstract fun buildQuery(): MutableMap<String, List<String>>
}

data class StandardBaseQuery (
    val cardType: String,
    override val attr: String
): QueryDecorator("class", attr) {
    private val format: String = "standard"
    override fun buildQuery(): MutableMap<String, List<String>> {
        return mutableMapOf(
            key to listOf(attr),
            "type" to listOf(cardType),
            "set" to listOf(format)
        )
    }
}

data class KeywordDec(
    override val attr: String,
    val query: QueryDecorator
): QueryDecorator("keyword", attr) {
    override fun buildQuery(): MutableMap<String, List<String>> {
        return addParamToMap(query.buildQuery())
    }
}

data class RarityDec(
    override val attr: String,
    val query: QueryDecorator
): QueryDecorator("rarity", attr) {
    override fun buildQuery(): MutableMap<String, List<String>> {
        return addParamToMap(query.buildQuery())
    }
}

data class ManaCostDec(
    override val attr: String,
    val query: QueryDecorator
): QueryDecorator("manaCost", attr) {
    override fun buildQuery(): MutableMap<String, List<String>> {
        return addParamToMap(query.buildQuery())
    }
}

data class MinionTypeDec(
    override val attr: String,
    val query: QueryDecorator
): QueryDecorator("minionType", attr) {
    override fun buildQuery(): MutableMap<String, List<String>> {
        return addParamToMap(query.buildQuery())
    }
}

data class TextFilterDec(
    override val attr: String,
    val query: QueryDecorator
): QueryDecorator("textFilter", attr) {
    override fun buildQuery(): MutableMap<String, List<String>> {
        return addParamToMap(query.buildQuery())
    }
}