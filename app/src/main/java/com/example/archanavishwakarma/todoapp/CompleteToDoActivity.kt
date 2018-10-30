package com.example.archanavishwakarma.todoapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_complete_to_do.*

class CompleteToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete_to_do)

        var title = intent.extras.getString("title")
        titleTextView.text  = title

        completeButton.setOnClickListener{
            var sharedPref = getSharedPreferences(getString(R.string.com_andorid_todo), 0);
            var todoSet = sharedPref.getStringSet(getString(R.string.TO_DO_STRINGS), setOf()).toMutableSet();

            todoSet.remove(title)

            sharedPref.edit().putStringSet(getString(R.string.TO_DO_STRINGS),todoSet).apply()
            finish()

        }
    }
}
