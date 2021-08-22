package com.highroll.db

import com.highroll.model.*
import com.highroll.model.SelectedClass.*

enum class CardData(
    val cardName: String,
    val query: QueryDecorator
) {

    // Scholomance Academy
    WANDMAKER("Wandmaker", ManaCostDec("1", BaseQuery("spell", CURRENT_NEUTRAL))),
    STEWARD_OF_SCROLLS("Steward of Scrolls", BaseQuery("spell", CURRENT_NEUTRAL)),
    ONYX_MAGESCRIBE("Onyx Magescribe", BaseQuery("spell", CURRENT_CLASS)),
    PLAGUED_PROTODRAKE("Plagued Protodrake", ManaCostDec("7", BaseQuery("minion", ALL))),
    NATURE_STUDIES("Nature Studies", BaseQuery("spell", CURRENT_NEUTRAL)),
    PARTNER_ASSIGNMENT("Partner Assignment", MinionTypeDec("beast", ManaCostDec("2,3", BaseQuery("spell", CURRENT_CLASS)))),
    CARRION_STUDIES("Carrion Studies", KeywordDec("deathrattle", BaseQuery("minion", CURRENT_NEUTRAL))),
    FIRST_DAY_OF_SCHOOL("First Day of School", ManaCostDec("1", BaseQuery("minion", ALL))),
    DRACONIC_STUDIES("Draconic Studies", MinionTypeDec("dragon", BaseQuery("minion", CURRENT_NEUTRAL))),
    SHIFTY_SOPHOMORE("Shifty Sophomore", KeywordDec("combo", BaseQuery("", CURRENT_NEUTRAL))),
    INSTRUCTOR_FIREHEART("Instructor Fireheart", BaseQuery("spell", CURRENT_NEUTRAL)),
    DEMONIC_STUDIES("Demonic Studies", MinionTypeDec("demon", BaseQuery("minion", CURRENT_NEUTRAL))),
    ATHLETIC_STUDIES("Athletic Studies", KeywordDec("rush", BaseQuery("minion", CURRENT_NEUTRAL))),
    IN_FORMATION("In Formation!", KeywordDec("taunt", BaseQuery("minion", CURRENT_NEUTRAL))),
    TEACHERS_PET("Teacher's Pet", ManaCostDec("3", MinionTypeDec("beast", BaseQuery("minion", ALL)))),
    PRIMORDIAL_STUDIES("Primordial Studies", KeywordDec("spell damage", BaseQuery("minion", CURRENT_NEUTRAL))),
    TRICK_TOTEM("Trick Totem", ManaCostDec("0,1,2,3", BaseQuery("spell", ALL))),
    WAND_THIEF("Wand Thief", BaseQuery("spell", MAGE)),
    JANDICE_BAROV("Jandice Barov", ManaCostDec("5", BaseQuery("minion", ALL)));

    companion object {
        private val map = values().associateBy { it.cardName }
        fun getCardByName(card: String): CardData? = map[card]
    }

}