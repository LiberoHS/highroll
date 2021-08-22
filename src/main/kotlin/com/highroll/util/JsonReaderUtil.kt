package com.highroll.util

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import java.io.File

class JsonReaderUtil {
    companion object {
        fun <T> loadResourceJsonIntoObject(filePath: String, classType: Class<T>): T {
            val jsonString: String = File("./src/test/resources$filePath").readText(Charsets.UTF_8)
            return ObjectMapper().registerModule(KotlinModule()).readValue(jsonString.trimIndent(), classType)
        }
    }
}