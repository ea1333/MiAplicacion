package com.example.miaplicacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.miaplicacion.api.API
import com.example.miaplicacion.modelo.Article
import com.example.miaplicacion.modelo.SearchResult
import kotlinx.android.synthetic.main.activity_results.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        val linearLayoutManager = LinearLayoutManager(this)
        recycler.layoutManager = linearLayoutManager

        val adapter = ArticlesAdapter()
        recycler.adapter = adapter

        val parametro = intent.extras?.getString("termino")

        API().search(parametro.toString(), object: Callback<SearchResult> {
            override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                resultsError.text = "¡Error!"
            }
            override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {
                if (response.isSuccessful) {
                    val resultado = response.body()?.results!!
                    adapter.articulos = resultado as ArrayList<Article>
                    adapter.notifyDataSetChanged()
                } else {
                    resultsError.text = "¡Error 2!"
                }
            }
        })
    }
}
