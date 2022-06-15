package com.example.myapplication12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toDict = findViewById<Button>(R.id.dictButton)
        val toTrad = findViewById<Button>(R.id.tradButton)

        toDict.setOnClickListener {
            val intent = Intent(this, DictActivity::class.java)
            startActivity(intent)
        }

        toTrad.setOnClickListener {
            val intent = Intent(this, TranslationActivity::class.java)
            startActivity(intent)
        }

    }
}