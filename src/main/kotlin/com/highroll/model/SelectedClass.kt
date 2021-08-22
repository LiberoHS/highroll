package com.highroll.model

enum class SelectedClass(
    val key: String
) {
    CURRENT_CLASS(""),
    CURRENT_NEUTRAL(",neutral"),
    ALL("all"),
    NEUTRAL("neutral"),
    DEMON_HUNTER("demonhunter"),
    DRUID("druid"),
    HUNTER("hunter"),
    MAGE("mage"),
    PALADIN("paladin"),
    PRIEST("priest"),
    ROGUE("rogue"),
    SHAMAN("shaman"),
    WARLOCK("warlock"),
    WARRIOR("warrior");

    companion object {
        private val map = values().associateBy { it.name }
        fun getCurrentDeck(deckClass: DeckClass): String = (map[deckClass.name] ?: error("")).key
        fun getCurrentNeutral(deckClass: DeckClass): String = "${getCurrentDeck(deckClass)},neutral"
    }
}