package com.hackathon.co.kr.neopenproject.ui.jk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hackathon.co.kr.neopenproject.MainActivity
import com.hackathon.co.kr.neopenproject.R
import kotlinx.android.synthetic.main.activity_check_done.*

class CheckDoneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_done)
        arrow.setOnClickListener {
            var intent = Intent(this@CheckDoneActivity, MainActivity::class.java).apply {

            }
            startActivity(intent)
            finish()
        }
    }
}
