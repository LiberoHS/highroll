package com.highroll

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HighrollApplication

fun main(args: Array<String>) {
    runApplication<HighrollApplication>(*args)
}
