package com.hackathon.co.kr.neopenproject.vo

import com.hackathon.co.kr.neopenproject.ui.jk.Lecture

data class Post(
        var id: Int,                // "" : 1,
        var max_time: Int,          // "": 2400,
        var title: String,          // "": ""isuure algorithm #180"",
        var sub_title: String,      // "": ""Task sub_title"",
        var subject: String,        // "": ""education"",
        var category: String,       // "": ""cause/solution"",
        var problem_img: String,    // "": ""images/problems/2019-08-25/156666646894836701.png"",
        var view: Int,              // "": 0,
        var author: String,         // "": ""TEA1566658976154392"",
        var affiliation: Int,       // "": 1,
        var created_at: Long,       // "": 15666664689518080,
        var updated_at: Long,       // "": 15666664689518080
        var count: Int
)

fun Post.refineToLecture(): Lecture {
    return Lecture(
            subject = this.subject,
            title = this.title,
            member = arrayListOf(),
            checked = this.count.toString(),
            count = this.count
    )
}

fun ArrayList<Post>.refineToLectures() : ArrayList<Lecture> {
    val list = arrayListOf<Lecture>()

    this.forEach { item ->
        list.add(item.refineToLecture())
    }

    return list
}