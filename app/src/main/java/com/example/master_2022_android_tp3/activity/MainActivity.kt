package com.example.master_2022_android_tp3.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.master_2022_android_tp3.R
import com.example.master_2022_android_tp3.adapter.AdapterTodo

class MainActivity : AppCompatActivity(), AdapterTodo.AdapterTodoListener {

    private lateinit var mLayoutManager: LinearLayoutManager
    private var mAdapter: AdapterTodo? = null
    private val RESULT_CODE_ADD: Int = 10
    private val RESULT_CODE_MODIFY: Int = 11
    private var mButtonAdd: Button? = null
    private var mRecyclerView: RecyclerView? = null
    private var mModificationPosition = -1
    private var listData = mutableListOf<String>(
        "TODO1",
        "TODO2",
        "TODO3",
        "TODO4",
        "TODO5",
        "TODO6",
        "TODO7",
        "TODO8",
        "TODO9",
        "TODO10"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRecyclerView = findViewById<RecyclerView>(R.id.activity_main_recyclerview)
        mButtonAdd = findViewById<Button>(R.id.activity_main_Button_add)

        // init the recyclerView
        mLayoutManager = LinearLayoutManager(baseContext)
        mRecyclerView?.layoutManager = mLayoutManager
        mAdapter = AdapterTodo(listData,this);
        mRecyclerView?.adapter = mAdapter

        mButtonAdd?.setOnClickListener {
            intent = Intent(this, ActivityAddTodo::class.java)
            startActivityForResult(intent, RESULT_CODE_ADD)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
        if (requestCode == RESULT_CODE_ADD || requestCode == RESULT_CODE_MODIFY) {
            val todostring =
                data?.getStringExtra(ActivityAddTodo.Constants.EXTRA_TODO_TITLE)
            if (!todostring.isNullOrEmpty())
                if (requestCode == RESULT_CODE_ADD) {
                    listData.add(todostring)
                } else{
                    listData[mModificationPosition]=todostring
                }
                mAdapter?.notifyDataSetChanged()
            }
        }
        else {
            Toast.makeText(this, getString(R.string.add_canceled), Toast.LENGTH_LONG).show()
        }
    }

    override fun onItemClicked(clickedView: View) {
        mModificationPosition = mLayoutManager.getPosition(clickedView)
        intent = Intent(this, ActivityAddTodo::class.java)
        intent.putExtra(ActivityAddTodo.Constants.EXTRA_TODO_TITLE,listData[mModificationPosition])
        startActivityForResult(intent, RESULT_CODE_MODIFY)
    }
}