package com.hackathon.co.kr.neopenproject.ui.jk

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hackathon.co.kr.neopenproject.util.NetworkUtil
import com.hackathon.co.kr.neopenproject.vo.Post
import com.hackathon.co.kr.neopenproject.vo.refineToLectures

class LectureViewModel(app: Application) : AndroidViewModel(app) {
    //저거 app 들어가는거 맞음?  ㅇㅇ 맞음
    var posts = MutableLiveData<ArrayList<Lecture>>()

    init {
        NetworkUtil.getInstance().getAnswerPost(
                onSuccess = { problemVO ->
                    posts.value = problemVO.result.problem_posts.refineToLectures()
                },
                onFailure = { t ->

                }
        )

    }


}