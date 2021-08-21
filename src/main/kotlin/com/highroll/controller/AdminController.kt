package com.highroll.controller

import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/api")
class AdminController {

    companion object {
        val log = KotlinLogging.logger {}
    }

    @GetMapping("/card/search")
    fun getCardQuery(): ResponseEntity<Void> {
        log.info { "Hellooooooo" }
        return ResponseEntity.ok().build()
    }
}