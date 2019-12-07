package com.example.miaplicacion.modelo

import com.google.gson.annotations.SerializedName

data class Article (val id : String,
                    @SerializedName("title") val title: String,
                    @SerializedName("original_price") val original_price : String,
                    @SerializedName("price") val price : String,
                    @SerializedName("thumbnail") val thumbnail : String,
                    @SerializedName("secure_thumbnail") val secure_thumbnail : String,
                    @SerializedName("condition") val condition : String,
                    val pictures: List<Picture>)

data class Picture(val id: String,
                   val url: String)