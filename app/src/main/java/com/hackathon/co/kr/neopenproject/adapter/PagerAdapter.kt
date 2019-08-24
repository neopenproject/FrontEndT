package com.hackathon.co.kr.neopenproject.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class PagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

    var pageCount = 0;
    constructor(fm: FragmentManager, pageCount: Int) : this(fm) {
        this.pageCount = pageCount
    }

    override fun getItem(position: Int): Fragment {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCount(): Int {
        return pageCount
    }

}