package com.hackathon.co.kr.neopenproject.ui.answer

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.hackathon.co.kr.neopenproject.ui.answer.repository.AnswerRepository
import com.hackathon.co.kr.neopenproject.vo.AnswerVO

class AnswerViewModel(app:Application) : AndroidViewModel(Application()){

    val answer= MutableLiveData<AnswerVO>()
    val answerRepository :AnswerRepository
    init {
        answerRepository = AnswerRepository()
    }

    fun getAnswerList(id:Int){
        answerRepository.getAnswer(
                id,
                onSuccess = {
                    answer.value = it
                },
                onFailure = {
                    Log.e("AnswerViewModel", it.message)
                }
        )
    }
}