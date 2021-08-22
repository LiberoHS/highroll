package com.highroll.model

data class HearthstoneCardResult(
    val cards: List<Card>,
    val cardCount: Int,
    val pageCount: Int,
    val page: Int
)