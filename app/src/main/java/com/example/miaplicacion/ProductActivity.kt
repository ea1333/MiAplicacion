package com.example.miaplicacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.miaplicacion.api.API
import com.example.miaplicacion.modelo.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_product.*
import kotlinx.android.synthetic.main.item_result.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val productId = intent.extras?.getString("productid")

        API().getArticle(productId.toString(), object: Callback<Article> {
            override fun onFailure(call: Call<Article>, t: Throwable) {

            }
            override fun onResponse(call: Call<Article>, response: Response<Article>) {
                val resp = response.body()

                val respPictures = response.body()?.pictures!!

                this@ProductActivity.productTitle.text = resp?.title
                this@ProductActivity.price.text = "$ ${resp?.price}"

                Picasso.get()
                    .load(respPictures[0].url)
                    .into(this@ProductActivity.image)

            }
        })
    }
}
