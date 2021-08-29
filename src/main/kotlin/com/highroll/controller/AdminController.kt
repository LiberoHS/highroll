package com.highroll.controller

import com.highroll.model.DeckClass
import com.highroll.model.DiscoverResults
import com.highroll.service.HearthstoneService
import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@CrossOrigin(origins = ["http://localhost:3000"])
@RequestMapping("/api")
class AdminController(
    private val hearthstoneService: HearthstoneService
) {

    companion object {
        val log = KotlinLogging.logger {}
    }

    @GetMapping("/card/search")
    fun getDiscoverableCards(@RequestParam card: String, @RequestParam deckClass: DeckClass): ResponseEntity<DiscoverResults> {
        log.info { "Querying for card: $card" }
        val res = hearthstoneService.getDiscoverableCards(card, deckClass)
        return ResponseEntity.ok().body(res)
    }

    @GetMapping("/deck/search")
    fun searchDeckByCode(@RequestParam deckCode: String) {
        // TODO: Add deck functionality
    }
}