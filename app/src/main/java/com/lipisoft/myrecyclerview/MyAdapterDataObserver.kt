package com.lipisoft.myrecyclerview

import android.support.v7.widget.RecyclerView
import android.util.Log

class MyAdapterDataObserver(val adapter : MyAdapter) : RecyclerView.AdapterDataObserver() {
    val TAG = "MyAdapterDataObserver"
    override fun onChanged() {
        super.onChanged()
        Log.d(TAG, "onChanged() is called.")
//        adapter.notifyDataSetChanged()
    }
}