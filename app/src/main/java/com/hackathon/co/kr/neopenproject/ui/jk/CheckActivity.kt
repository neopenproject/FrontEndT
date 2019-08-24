package com.hackathon.co.kr.neopenproject.ui.jk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hackathon.co.kr.neopenproject.R
import kotlinx.android.synthetic.main.activity_check.*

class CheckActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check)

        bt_dropdown.setOnClickListener {
            if(iv_problem_c.visibility == View.VISIBLE)
                iv_problem_c.visibility = View.GONE
            else
                iv_problem_c.visibility = View.VISIBLE
        }
    }

}
