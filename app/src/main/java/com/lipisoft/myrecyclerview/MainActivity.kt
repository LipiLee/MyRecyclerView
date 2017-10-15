package com.lipisoft.myrecyclerview

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    val update = 1
    private lateinit var handler : Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        val list : MutableList<Packet> = mutableListOf()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        my_recycler_view.setHasFixedSize(false)
        my_recycler_view.layoutManager = LinearLayoutManager(this)

        my_recycler_view.adapter = MyAdapter(list)

        handler = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message?) {
                if (msg != null) {
                    when(msg.what) {
                        update -> my_recycler_view.adapter.notifyDataSetChanged()
                        else -> super.handleMessage(msg)
                    }
                }
            }
        }

        Thread(Runnable
            {
                while (true) {
                    list.add(Packet(DateFormat.getDateTimeInstance().format(Date()), "TCP"))
                    handler.obtainMessage(update).sendToTarget()
                    Thread.sleep(500)
                }
            }
        ).start()
    }
}
