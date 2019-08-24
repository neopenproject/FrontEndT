package com.hackathon.co.kr.neopenproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hackathon.co.kr.neopenproject.BR
import com.hackathon.co.kr.neopenproject.databinding.ItemRecyclerLayoutBinding
import com.hackathon.co.kr.neopenproject.vo.CourseVO
import com.hackathon.co.kr.neopenproject.vo.ResponseVO

class RecyclerViewAdapter(): RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {
    lateinit var context: Context
    var items: ArrayList<CourseVO> = arrayListOf()

    constructor(context: Context):this(){
        this.context = context
        this.items = ArrayList()
    }

    fun replaceAll(newItems: ArrayList<CourseVO>) {
        items.apply {
            clear()
            addAll(newItems)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val binding = ItemRecyclerLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val item = items.get(position)
        holder.bind(item)
    }

    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var binding: ItemRecyclerLayoutBinding
        constructor(binding: ItemRecyclerLayoutBinding) : this(binding.root){
            this.binding = binding
        }

        fun bind(item: CourseVO) {
            binding.setVariable(BR.item, item)
        }
    }
}