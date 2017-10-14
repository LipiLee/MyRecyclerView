package com.lipisoft.myrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.my_recycler_view
import java.text.DateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val myDataset : MutableList<Packet> = mutableListOf()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        my_recycler_view.setHasFixedSize(false)
        my_recycler_view.layoutManager = LinearLayoutManager(this)

        my_recycler_view.adapter = MyAdapter(myDataset)

        val handler = Handler(Looper.getMainLooper()) {

        }
        Thread(Runnable
            {
                while (true) {
                    myDataset.add(Packet(DateFormat.getDateTimeInstance().format(Date()), "TCP"))
                    my_recycler_view.adapter.notifyDataSetChanged()
                    Thread.sleep(500)
                }
            }
        ).start()
    }
}
