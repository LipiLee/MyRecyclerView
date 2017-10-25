package com.lipisoft.myrecyclerview

import android.os.Handler
import android.os.Looper
import android.os.Message
import android.support.v7.widget.RecyclerView
import java.text.DateFormat
import java.util.*

class MyRunnable(val adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>) : Runnable {
    override fun run() {
        val handler = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message?) {
                if (msg != null) {
                    when(msg.what) {
                        Manager.update -> adapter.notifyDataSetChanged()
                        else -> super.handleMessage(msg)
                    }
                }
            }
        }

        while (true) {
            Manager.add(Packet(DateFormat.getDateTimeInstance().format(Date()), "TCP"))
            handler.obtainMessage(Manager.update).sendToTarget()
            Thread.sleep(500)
        }

    }
}