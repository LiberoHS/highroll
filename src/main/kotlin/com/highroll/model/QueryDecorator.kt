package com.highroll.model

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

    abstract fun buildQuery(deckClass: DeckClass): MutableMap<String, List<String>>
}

data class BaseQuery (
    override val attr: String,
    val className: SelectedClass
): QueryDecorator("type", attr) {
    private val format: String = "standard"
    override fun buildQuery(deckClass: DeckClass): MutableMap<String, List<String>> {
        val classKey: String = when (className) {
            SelectedClass.CURRENT_CLASS -> SelectedClass.getCurrentDeck(deckClass)
            SelectedClass.CURRENT_NEUTRAL -> SelectedClass.getCurrentNeutral(deckClass)
            else -> className.key
        }

        return mutableMapOf(
            key to listOf(attr),
            "class" to listOf(classKey),
            "set" to listOf(format)
        )
    }
}

data class KeywordDec(
    override val attr: String,
    val query: QueryDecorator
): QueryDecorator("keyword", attr) {
    override fun buildQuery(deckClass: DeckClass): MutableMap<String, List<String>> {
        return addParamToMap(query.buildQuery(deckClass))
    }
}

data class RarityDec(
    override val attr: String,
    val query: QueryDecorator
): QueryDecorator("rarity", attr) {
    override fun buildQuery(deckClass: DeckClass): MutableMap<String, List<String>> {
        return addParamToMap(query.buildQuery(deckClass))
    }
}

data class ManaCostDec(
    override val attr: String,
    val query: QueryDecorator
): QueryDecorator("manaCost", attr) {
    override fun buildQuery(deckClass: DeckClass): MutableMap<String, List<String>> {
        return addParamToMap(query.buildQuery(deckClass))
    }
}

data class MinionTypeDec(
    override val attr: String,
    val query: QueryDecorator
): QueryDecorator("minionType", attr) {
    override fun buildQuery(deckClass: DeckClass): MutableMap<String, List<String>> {
        return addParamToMap(query.buildQuery(deckClass))
    }
}

data class TextFilterDec(
    override val attr: String,
    val query: QueryDecorator
): QueryDecorator("textFilter", attr) {
    override fun buildQuery(deckClass: DeckClass): MutableMap<String, List<String>> {
        return addParamToMap(query.buildQuery(deckClass))
    }
}