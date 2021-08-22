package com.highroll.model

data class Card(
    val id: String,
    val name: String,
    val text: String,
    val image: String,
    val classId: Int,
    val manaCost: Int,
    val attack: Int,
    val health: Int?,
    val durability: Int?,
    val keywordIds: List<Int>?
)