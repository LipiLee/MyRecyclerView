package com.lipisoft.myrecyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class MyAdapter(private val list: MutableList<Packet>) : RecyclerView.Adapter<MyViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder? {
        if (parent != null) {
            return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false))
        }
        return null
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        if (holder != null) {
            holder.date.text = list[position].date
            holder.protocol.text = list[position].protocol
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}