package com.example.myapplication12

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication12.models.Lecto.RequestBody
import com.example.myapplication12.models.Lecto.TranslatedText
import com.example.myapplication12.interfaces.LectoApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TranslationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_translation)

        val textToTranslate = findViewById<EditText>(R.id.TextToTranslate)
        val translatedText = findViewById<EditText>(R.id.TranslatedText)
        val button = findViewById<Button>(R.id.Translate)

        //from spinner
        val fromSpinner: Spinner = findViewById(R.id.fromSpinner)
            // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.lang,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            fromSpinner.adapter = adapter
        }

        //to spinner
        val toSpinner: Spinner = findViewById(R.id.toSpinner)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.lang,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            toSpinner.adapter = adapter
        }
        // button click listener
        button.setOnClickListener{

            val from: String = fromSpinner.selectedItem.toString()

            val to: String = toSpinner.selectedItem.toString()

            val textTT = arrayListOf(textToTranslate.text.toString())


            val lang = arrayListOf(to)

            val req = RequestBody(textTT,lang,from)

            val apiInterface = LectoApiInterface.create().getTranslation(req)


            apiInterface.enqueue( object : Callback<TranslatedText> {
                override fun onResponse(call: Call<TranslatedText>?, response: Response<TranslatedText>?) {

                    if(response?.body() != null){
                        Log.i("error", response.body().toString())
                        translatedText.setText(response.body()!!.translations[0].translated[0])

                    }

                }

                override fun onFailure(call: Call<TranslatedText>?, t: Throwable?) {
                    if (t != null) {
                        t.message?.let { it1 -> Log.i("error", it1) }
                    }
                }
            })

        }

    }
}