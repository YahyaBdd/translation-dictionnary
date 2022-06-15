package com.example.myapplication12.interfaces

import android.util.Log
import com.example.myapplication12.models.Lecto.RequestBody

import com.example.myapplication12.models.Lecto.TranslatedText
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface LectoApiInterface {


    @Headers("X-API-Key: SZ769CZ-2MWMNG9-KMTHA3J-GJX9HAS\n")
    @POST("text")
    fun getTranslation(@Body req: RequestBody) : Call<TranslatedText>
    companion object {

        var BASE_URL = "https://api.lecto.ai/v1/translate/"

        fun create() : LectoApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            Log.i("error","retrofit instance created")
            return retrofit.create(LectoApiInterface::class.java)

        }
    }
}