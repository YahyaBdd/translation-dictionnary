package com.example.myapplication12.models.Lecto

import com.google.gson.annotations.SerializedName


data class Translations (

  @SerializedName("to"         ) var to         : String?           = null,
  @SerializedName("translated" ) var translated : ArrayList<String> = arrayListOf()

)