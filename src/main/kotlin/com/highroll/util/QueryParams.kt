package com.highroll.util

import org.springframework.util.MultiValueMap

interface QueryParams: MultiValueMap<String, String> {
    fun addParam(key: String, value: String) {
        this[key] = value
    }
}