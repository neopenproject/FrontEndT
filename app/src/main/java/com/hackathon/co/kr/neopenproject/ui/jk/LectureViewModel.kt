package com.hackathon.co.kr.neopenproject.ui.jk

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LectureViewModel(app:Application):AndroidViewModel(app) {

    lateinit var lecListAdapter: LecListAdapter
    //저거 app 들어가는거 맞음?
    var layoutManager = LinearLayoutManager(app, RecyclerView.VERTICAL, false)
    init {

    }


}