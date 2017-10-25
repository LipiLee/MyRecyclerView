package com.lipisoft.myrecyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        my_recycler_view.setHasFixedSize(false)
        my_recycler_view.layoutManager = LinearLayoutManager(this)

        my_recycler_view.adapter = MyAdapter(Manager.list)

        Thread(MyRunnable(my_recycler_view.adapter)).start()
    }
}
