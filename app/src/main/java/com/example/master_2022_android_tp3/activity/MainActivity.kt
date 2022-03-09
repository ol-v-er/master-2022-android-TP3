package com.example.master_2022_android_tp3.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.master_2022_android_tp3.R
import com.example.master_2022_android_tp3.adapter.AdapterTodo

class MainActivity : AppCompatActivity() {

    private var mRecyclerView: RecyclerView? = null
    private var listData = mutableListOf<String>("TODO1","TODO2","TODO3","TODO4","TODO5","TODO6","TODO7","TODO8","TODO9","TODO10")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        mRecyclerView = findViewById<RecyclerView>(R.id.activity_main_recyclerview)

        // init the recyclerView
        mRecyclerView?.layoutManager = LinearLayoutManager(baseContext)
        mRecyclerView?.adapter = AdapterTodo(listData)

    }
}