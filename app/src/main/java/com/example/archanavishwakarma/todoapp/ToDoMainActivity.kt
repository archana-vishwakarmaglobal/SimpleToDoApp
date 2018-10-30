package com.example.archanavishwakarma.todoapp

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_to_do_main.*
import kotlinx.android.synthetic.main.content_to_do_main.*

class ToDoMainActivity : AppCompatActivity() {
     lateinit var layoutManager :RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            val intent = Intent(this, CreateToDoActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        updateRecycler()
    }
    fun updateRecycler(){
        var sharedPref = getSharedPreferences(getString(R.string.com_andorid_todo), 0);
        var todoSet = sharedPref.getStringSet(getString(R.string.TO_DO_STRINGS), setOf()).toMutableSet();

        layoutManager = LinearLayoutManager(this)
        todorecyclerview.layoutManager = layoutManager
        todorecyclerview.adapter = ToDoRecyclerViewAdapter(todoSet.toList())
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_to_do_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if(item.itemId == R.id.action_delete_all){
            var sharedPref = getSharedPreferences(getString(R.string.com_andorid_todo), 0);
            sharedPref.edit().putStringSet(getString(R.string.TO_DO_STRINGS), setOf()).apply()

            updateRecycler()

            return true
        }
        return super.onOptionsItemSelected(item)

    }
}
