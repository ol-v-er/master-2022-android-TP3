package com.example.master_2022_android_tp3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.master_2022_android_tp3.R

class AdapterTodo(private val dataSet: MutableList<String>, private val listener:AdapterTodoListener) :
        RecyclerView.Adapter<AdapterTodo.ViewHolder>() {

    interface AdapterTodoListener{
        fun onItemClicked(clickedView:View)
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewTitle: TextView
        val textViewDescription: TextView
        init {
            // Define click listener for the ViewHolder's View.
            textViewTitle = view.findViewById(R.id.cell_item_todo_TextView_title)
            textViewDescription = view.findViewById(R.id.cell_item_todo_TextView_description)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.cell_item_todo, viewGroup, false)
        view.setOnClickListener {
            listener.onItemClicked(view)
        }
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textViewTitle.text = dataSet[position]
        viewHolder.textViewDescription.text = dataSet[position]
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}