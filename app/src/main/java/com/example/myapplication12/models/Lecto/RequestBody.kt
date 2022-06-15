package com.example.myapplication12.models.Lecto

import com.google.gson.annotations.SerializedName


data class RequestBody (

  @SerializedName("texts" ) var texts : ArrayList<String> = arrayListOf(),
  @SerializedName("to"    ) var to    : ArrayList<String> = arrayListOf(),
  @SerializedName("from"  ) var from  : String?           = null

)