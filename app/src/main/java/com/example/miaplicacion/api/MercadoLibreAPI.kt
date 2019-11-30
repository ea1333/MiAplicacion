package com.example.miaplicacion.api

import retrofit2.Call
import com.example.miaplicacion.modelo.Article
import com.example.miaplicacion.modelo.SearchResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MercadoLibreAPI {
    @GET("items/{itemId}")
    fun getArticle(@Path("itemId") id: String): Call<Article>


    @GET("sites/MLA/search")
    fun search(@Query("q") query: String): Call<SearchResult>
}