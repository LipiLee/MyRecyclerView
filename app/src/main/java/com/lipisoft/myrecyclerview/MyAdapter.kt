package com.lipisoft.myrecyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class MyAdapter(val mDataSet: MutableList<Packet>) : RecyclerView.Adapter<MyViewHolder> (){
    init {
//        registerAdapterDataObserver(MyAdapterDataObserver(this))
    }
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder? {
        if (parent != null) {
            return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false))
        }
        return null
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        if (holder != null) {
            holder.date.text = mDataSet[position].date
            holder.protocol.text = mDataSet[position].protocol
        }
    }

    override fun getItemCount(): Int {
        return mDataSet.size
    }
}