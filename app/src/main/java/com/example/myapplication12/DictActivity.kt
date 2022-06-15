package com.example.myapplication12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication12.interfaces.ApiInterface

import Word
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication12.adapters.DictAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DictActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dict)

        val textField = findViewById<EditText>(R.id.editTextTextPersonName)

        val button = findViewById<Button>(R.id.button)
        val word = findViewById<TextView>(R.id.word)
        val phonetic = findViewById<TextView>(R.id.phonetic)
        val definitionsRV = findViewById<RecyclerView>(R.id.definitionsRV)
        val linearLayoutManager = LinearLayoutManager(this)
        definitionsRV.layoutManager = linearLayoutManager
        button.setOnClickListener {
            val apiInterface = ApiInterface.create().getWord(textField.text.toString())

            apiInterface.enqueue( object : Callback<List<Word>> {
                override fun onResponse(call: Call<List<Word>>?, response: Response<List<Word>>?) {

                    if(response?.body() != null){
                        definitionsRV.adapter=DictAdapter(response.body()!![0].meanings)
                        phonetic.text = response.body()!![0].phonetic
                        word.text = "Definitions for " + response.body()!![0].word

                    }

                }

                override fun onFailure(call: Call<List<Word>>?, t: Throwable?) {

                }
            })

        }



        }

    }

