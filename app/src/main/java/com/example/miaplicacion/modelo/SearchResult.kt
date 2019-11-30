package com.example.miaplicacion.modelo

import com.google.gson.annotations.SerializedName

data class SearchResult (@SerializedName("results") val results : List<Article>)