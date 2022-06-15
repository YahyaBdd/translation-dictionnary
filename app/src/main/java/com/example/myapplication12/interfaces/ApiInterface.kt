package com.example.myapplication12.interfaces

import Word
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("{word}")
    fun getWord(@Path("word") word:String) : Call<List<Word>>

    companion object {

        var BASE_URL = "https://api.dictionaryapi.dev/api/v2/entries/en/"

        fun create() : ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}