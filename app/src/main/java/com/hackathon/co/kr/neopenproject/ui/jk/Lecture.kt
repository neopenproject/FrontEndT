package com.hackathon.co.kr.neopenproject.ui.jk

import com.google.gson.JsonObject

data class Lecture(
        var id : Int,
        var subject: String,
        var title: String,
        var member: ArrayList<JsonObject>,
        var checked: String,
        var count : Int
)

fun getGenerateLecture(): Lecture {
    return Lecture(
            id = 0,
            subject = "123",
            title = "456",
            member = arrayListOf(),
            checked = "5",
            count = 5
    )
}