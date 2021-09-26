package com.example.recyclerviewapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var myLayout = findViewById<ConstraintLayout>(R.id.clMain)
        val words = arrayListOf<String>()
        val editText = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            if (!editText.text.isEmpty()) {
                words.add(editText.text.toString())
                editText.text.clear()
                val myRv = findViewById<RecyclerView>(R.id.recyclerView)
                myRv.adapter = RecyclerViewAdapter(words)
                myRv.layoutManager = LinearLayoutManager(this)
            }else{
             Snackbar.make(myLayout,"Add text please the text is empty",Snackbar.LENGTH_LONG).show()
            }
        }

    }
}