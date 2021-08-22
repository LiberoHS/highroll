package com.highroll.controller

import com.highroll.model.HearthstoneCardResult
import com.highroll.service.HearthstoneService
import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/api")
class AdminController(
    private val hearthstoneService: HearthstoneService
) {

    companion object {
        val log = KotlinLogging.logger {}
    }

    @GetMapping("/card/search")
    fun getDiscoverableCards(@RequestParam card: String, @RequestParam deckClass: String): ResponseEntity<HearthstoneCardResult> {
        log.info { "Querying for card: $card" }
        val res = hearthstoneService.getDiscoverableCards()
        return ResponseEntity.ok().body(res)
    }
}