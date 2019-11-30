package com.example.miaplicacion.api

import com.example.miaplicacion.modelo.Article
import com.example.miaplicacion.modelo.SearchResult
import com.google.gson.Gson
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class API {
    private fun getAPI() : MercadoLibreAPI {
        val retrofit =  Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .baseUrl("https://api.mercadolibre.com")
            .build()
        return retrofit.create(MercadoLibreAPI::class.java)
    }
    fun getArticle(id: String, callback: Callback<Article>) {
        getAPI().getArticle(id).enqueue(callback)
    }
    fun search(query: String, callback: Callback<SearchResult>) {
        getAPI().search(query).enqueue(callback)
    }
}