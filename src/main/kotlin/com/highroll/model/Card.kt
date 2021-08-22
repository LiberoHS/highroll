package com.highroll.model

import com.fasterxml.jackson.annotation.JsonIgnore

data class Card(
    val id: String,
    val name: String,
    val text: String,
    val image: String,
    @JsonIgnore
    val classId: Int,
    @JsonIgnore
    val manaCost: Int,
    @JsonIgnore
    val attack: Int,
    @JsonIgnore
    val health: Int?,
    @JsonIgnore
    val durability: Int?,
    @JsonIgnore
    val keywordIds: List<Int>?
)