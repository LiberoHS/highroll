package com.highroll.util

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule

class ObjectMapperUtil {
    companion object {
        val OBJECT_MAPPER = ObjectMapper().registerModule(KotlinModule())
    }
}