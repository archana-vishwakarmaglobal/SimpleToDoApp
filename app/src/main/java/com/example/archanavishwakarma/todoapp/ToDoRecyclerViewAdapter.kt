package com.example.archanavishwakarma.todoapp

import android.content.Intent
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.layout_todo_row.view.*

class ToDoRecyclerViewAdapter(var datasets : List<String> ) : RecyclerView.Adapter<ToDoRecyclerViewAdapter.ToDOViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ToDOViewHolder {
         return ToDOViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.layout_todo_row,p0,false))
    }

    override fun getItemCount(): Int {
         return datasets.size
    }

    override fun onBindViewHolder(p0: ToDOViewHolder, p1: Int) {
         p0.bindTodos(datasets.get(p1))
    }

    class ToDOViewHolder(var v: View):RecyclerView.ViewHolder(v) , View.OnClickListener{
        var view = v;
        var title = ""
        init {
            view.setOnClickListener(this)
        }
        fun bindTodos(todoString:String){
            view.titleTextView.text = todoString
            title  = todoString
        }
        override fun onClick(v: View?) {
            var intent = Intent(view.context,CompleteToDoActivity::class.java)
            intent.putExtra("title",title)
            ContextCompat.startActivity(view.context, intent,null)
        }


    }
}