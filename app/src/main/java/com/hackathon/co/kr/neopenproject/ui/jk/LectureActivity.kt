package com.hackathon.co.kr.neopenproject.ui.jk

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hackathon.co.kr.neopenproject.BR
import com.hackathon.co.kr.neopenproject.R
import com.hackathon.co.kr.neopenproject.adapter.BaseRecyclerView
import com.hackathon.co.kr.neopenproject.base.BaseActivity
import com.hackathon.co.kr.neopenproject.databinding.ActivityLectureBinding
import com.hackathon.co.kr.neopenproject.databinding.ItemLectureListBinding
import com.hackathon.co.kr.neopenproject.ui.answer.AnswerListActivity
import com.hackathon.co.kr.neopenproject.vo.Post

import kotlinx.android.synthetic.main.activity_lecture.*

class LectureActivity(override var layoutResource: Int = R.layout.activity_lecture) : BaseActivity() {
    lateinit var binding: ActivityLectureBinding
    val lectureVM by lazy {
        ViewModelProviders.of(this).get(LectureViewModel::class.java)
    }
    lateinit var lectureAdapter: BaseRecyclerView.Adapter<Lecture, ItemLectureListBinding>

    override fun onDataBind() {
        binding = DataBindingUtil.setContentView(this, layoutResource)
        binding.activity = this
        binding.lectureVM = lectureVM
    }

    override fun getIsUseDataBinding(): Boolean {
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lec_list.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        lectureAdapter = object : BaseRecyclerView.Adapter<Lecture, ItemLectureListBinding>(
                layoutResId = R.layout.item_lecture_list,
                bindingVariableId = BR.icLecture
        ) {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<ItemLectureListBinding> {
                return super.onCreateViewHolder(parent, viewType).apply {
                    this.itemView.setOnClickListener {
                        startActivity(
                                Intent(this@LectureActivity, AnswerListActivity::class.java).apply {
                                     putExtra("subject", lectureVM.posts.value?.get(adapterPosition)?.subject)
                                     putExtra("title", lectureVM.posts.value?.get(adapterPosition)?.title)
                                     putExtra("id", lectureVM.posts.value?.get(adapterPosition)?.id)
                                }
                        )
                    }
                }
            }

            override fun onBindViewHolder(holder: ViewHolder<ItemLectureListBinding>, position: Int) {
                super.onBindViewHolder(holder, position)
            }
        }
        lec_list.adapter = lectureAdapter
    }

    override fun subScribeUI() {
        super.subScribeUI()

        lectureVM.posts.observe(this, Observer { posts ->
            lectureAdapter.replaceAll(posts)
        })
    }
}
