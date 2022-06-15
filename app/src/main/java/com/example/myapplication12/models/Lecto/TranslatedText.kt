package com.example.myapplication12.models.Lecto

import com.example.myapplication12.models.Lecto.Translations
import com.google.gson.annotations.SerializedName


data class TranslatedText (

  @SerializedName("translations"          ) var translations         : ArrayList<Translations> = arrayListOf(),
  @SerializedName("from"                  ) var from                 : String?                 = null,
  @SerializedName("translated_characters" ) var translatedCharacters : Int?                    = null

)