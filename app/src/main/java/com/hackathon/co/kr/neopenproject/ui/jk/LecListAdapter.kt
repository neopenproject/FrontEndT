package com.hackathon.co.kr.neopenproject.ui.jk

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hackathon.co.kr.neopenproject.BR
import com.hackathon.co.kr.neopenproject.databinding.ItemLectureListBinding

class LecListAdapter(val context: Context, val itemlist: ArrayList<Lecture>) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemLectureListBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding).apply {

        }
    }

    override fun getItemCount(): Int {
        return itemlist.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var binding: ItemLectureListBinding

        constructor(binding: ItemLectureListBinding) : this(binding.root) {
            Log.d("ViewHolder", " create")
            this.binding = binding
        }

        fun bind(lecture: Lecture) {
            binding.setVariable(BR.icLecture, lecture)
        }

    }
}