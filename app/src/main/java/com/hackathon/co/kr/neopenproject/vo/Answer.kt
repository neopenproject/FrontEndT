package com.hackathon.co.kr.neopenproject.vo

data class Answer (
    var id: Int,
    var time: Int,
    var answer_img: String,
    var is_over: Boolean,
    var author: String,
    var is_grade_view: Boolean,
    var score: String,
    var problem_post: Int,
    var comment: String,
    var is_teacher_view: Boolean,
    var is_grade: Boolean,
    var created_at: Int,
    var updated_at: Int
)