package com.example.master_2022_android_tp3.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.master_2022_android_tp3.R

class ActivityAddTodo : AppCompatActivity() {

    private var mEditTextTitle: EditText?=null
    private var mEditTextDescription: EditText? = null
    private var mButtonAdd: Button? = null

    object Constants {
        const val EXTRA_RESULT_TODO_STRING = "TODO_STRING"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_todo)

        mEditTextTitle = findViewById<EditText>(R.id.activity_add_todo_EditText_title)
        mEditTextDescription = findViewById<EditText>(R.id.activity_add_todo_EditText_title)
        mButtonAdd = findViewById<Button>(R.id.activity_add_todo_Button_add)

        mButtonAdd?.setOnClickListener {
            val title = mEditTextTitle?.text.toString()
            val description = mEditTextDescription?.text
            if (!title.isNullOrEmpty()) {
                intent = Intent()
                intent.putExtra(Constants.EXTRA_RESULT_TODO_STRING,title)
                setResult(Activity.RESULT_OK,intent)
            }else
            {
                setResult(Activity.RESULT_CANCELED)
            }
            finish()
        }
    }
}