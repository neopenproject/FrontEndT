package com.hackathon.co.kr.neopenproject.ui.jk

import com.google.gson.JsonObject

data class Lecture(
        var subject: String,
        var title: String,
        var member: ArrayList<JsonObject>,
        var checked: String
)

fun getGenerateLecture(): Lecture {
    return Lecture(
            subject = "123",
            title = "456",
            member = arrayListOf(),
            checked = "5"
    )
}