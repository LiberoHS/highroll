package com.highroll.util

import com.highroll.util.ObjectMapperUtil.Companion.OBJECT_MAPPER
import java.io.File

class JsonReaderUtil {
    companion object {
        fun <T> loadResourceJsonIntoObject(filePath: String, classType: Class<T>): T {
            val jsonString: String = File("./src/test/resources$filePath").readText(Charsets.UTF_8)
            return OBJECT_MAPPER.readValue(jsonString.trimIndent(), classType)
        }
    }
}