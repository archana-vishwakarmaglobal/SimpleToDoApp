package com.example.archanavishwakarma.todoapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_to_do.*

class CreateToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_to_do)

        addButton.setOnClickListener{
            var title = ""
            if(importantCheckBox.isChecked){
                title = "Imp - "+ titleEditText.text
            }else{
                title = ""+ titleEditText.text
            }
            var sharedPre = getSharedPreferences(getString(R.string.com_andorid_todo),0);

            var todoSet = sharedPre.getStringSet(getString(R.string.TO_DO_STRINGS), setOf()).toMutableSet()
            todoSet.add(title)
            sharedPre.edit().putStringSet("todostrings",todoSet).commit()

            finish()
        }
    }
}
