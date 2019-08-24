package com.hackathon.co.kr.neopenproject.vo

import com.google.gson.JsonObject

data class ResponseVO (
        var code: String = " ",
        var result: JsonObject = JsonObject()
)