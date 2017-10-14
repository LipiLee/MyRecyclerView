package com.lipisoft.myrecyclerview

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

class MyViewHolder(item : View) : RecyclerView.ViewHolder(item) {
    var date : TextView = item.findViewById(R.id.date)
    var protocol : TextView = item.findViewById(R.id.protocol)
}
