package com.example.miaplicacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnBuscar.setOnClickListener {
            val ingresado = campoDeBusqueda.text.toString()
            Log.e("Hola", ingresado)
            val intent = Intent(this, ResultsActivity::class.java)

            intent.putExtra("termino", ingresado)

            startActivity(intent)
        }

        /*API().getArticle("MLA636004656", object:Callback<Article> {
            override fun onFailure(call: Call<Article>, t: Throwable) {
                texto.text = "FALLó!"
            }
            override fun onResponse(call: Call<Article>, response: Response<Article>) {
                if (response.isSuccessful) {
                    val received : Article? = response.body()
                    texto.text = received?.title
                }
            }
        })*/
    }
}
