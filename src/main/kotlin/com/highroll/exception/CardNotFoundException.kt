package com.highroll.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.server.ResponseStatusException

@ResponseStatus(value = HttpStatus.NOT_FOUND)
class CardNotFoundException(
    errorMessage: String
): ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage)