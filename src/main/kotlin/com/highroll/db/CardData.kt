package com.highroll.db

import com.highroll.model.*
import com.highroll.model.SelectedClass.*

enum class CardData(
    val cardName: String,
    val query: QueryDecorator
) {

    // United in Stormwind
    CALL_OF_THE_GRAVE("Call of the Grave", KeywordDec("deathrattle", BaseQuery("minion", CURRENT_NEUTRAL))),
    // TODO: Spy Gizmo
    TINY_TOYS("Tiny Toys", ManaCostDec("5", BaseQuery("minion", ALL))),
    // TODO: CHARGED_CALL
    LADY_PRESTOR("Lady Prestor", MinionTypeDec("dragon", BaseQuery("minion", ALL))),
    ENTRAPPED_SORCERESS("Entrapped Sorceress", BaseQuery("spell", CURRENT_NEUTRAL)),
    // TODO: PANDAREN_IMPORTER
    DEEPRUN_ENGINEER("Deeprun Engineer", MinionTypeDec("mech", BaseQuery("minion", CURRENT_NEUTRAL))),
    STUBBORN_SUSPECT("Stubborn Suspect", ManaCostDec("3", BaseQuery("minion", ALL))),

    // Miniset: Wailing Caverns
    // TODO: SAVORY_DEVIATE_DELIGHT
    // TODO: ARCHDRUID_NARALEX
    // TODO: ADVENTURERS

    // Forged at the Barrens
    // TODO: PACK_KODO
    RUNED_ORB("Runed Orb", BaseQuery("spell", CURRENT_NEUTRAL)),
    PEON("Peon", BaseQuery("spell", CURRENT_CLASS)),
    VENOMOUS_SCORPID("Venomous Scorpid", BaseQuery("spell", CURRENT_NEUTRAL)),

    // Miniset: Darkmoon Races
    // TODO: Verify
    ILLIDARI_STUDIES("Illidari Studies", KeywordDec("outcast", BaseQuery("", DEMON_HUNTER))),
    GUIDANCE("Guidance", BaseQuery("spell", CURRENT_NEUTRAL)),
    // TODO: RESIZING_POUCH
    SADDLEMASTER("Saddlemaster", MinionTypeDec("beast", BaseQuery("minion", CURRENT_CLASS))),
    // TODO: KEYWARDEN_IVORY

    // Madness at the Darkmoon Faire
    MYSTERY_WINNER("Mystery Winner", KeywordDec("secret", BaseQuery("spell", CURRENT_NEUTRAL))),
    RINLING_RIFLE("Rinling's Rifle", KeywordDec("secret", BaseQuery("spell", CURRENT_NEUTRAL))),
    RING_TOSS("Ring Toss", KeywordDec("secret", BaseQuery("spell", CURRENT_NEUTRAL))),

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
    JANDICE_BAROV("Jandice Barov", ManaCostDec("5", BaseQuery("minion", ALL))),

    // Ashes of Outland
    NETHERWALKER("Netherwalker", MinionTypeDec("demon", BaseQuery("minion", CURRENT_NEUTRAL))),
    MARSH_HYDRA("Marsh Hydra", ManaCostDec("8", BaseQuery("minion", ALL))),
    NETHERWIND_PORTAL("Netherwind Portal", ManaCostDec("4", BaseQuery("minion", ALL))),
    FONT_OF_POWER("Font of Power", BaseQuery("minion", MAGE)),
    APEXIS_SMUGGLER("Apexis Smuggler", BaseQuery("spell", CURRENT_NEUTRAL)),
    APEXIS_BLAST("Apexis Blast", ManaCostDec("5", BaseQuery("minion", ALL))),
    EVOCATION("Evocation", BaseQuery("spell", MAGE)),
    SOLARIAN_PRIME("Solarian Prime", BaseQuery("spell", MAGE)),
    UNDERLIGHT_ANGLING_ROD("Underlight Angling Rod", MinionTypeDec("murloc", BaseQuery("minion", CURRENT_NEUTRAL))),
    MURGURGLE_PRIME("Murgurgle Prime", MinionTypeDec("murloc", BaseQuery("minion", CURRENT_NEUTRAL))),
    RENEW("Renew", BaseQuery("spell", CURRENT_NEUTRAL)),
    SETHEKK_VEILWEAVER("Sethekk Veilweaver", BaseQuery("spell", PRIEST)),
    SKELETAL_DRAGON("Skeletal Dragon", MinionTypeDec("dragon", BaseQuery("minion", CURRENT_NEUTRAL))),
    MARSHSPAWN("Marshspawn", BaseQuery("spell", CURRENT_NEUTRAL)),
    SERPENTSHRINE_PORTAL("Serpentshrine Portal", ManaCostDec("3", BaseQuery("minion", ALL))),
    SHADOW_COUNCIL("Shadow Council", MinionTypeDec("demon", BaseQuery("minion", ALL)));

    companion object {
        private val map = values().associateBy { it.cardName }
        fun getCardByName(card: String): CardData? = map[card]
    }
}