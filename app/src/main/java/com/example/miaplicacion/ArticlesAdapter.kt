package com.example.miaplicacion

import android.content.Intent
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.miaplicacion.modelo.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_result.view.*

class ArticlesAdapter: RecyclerView.Adapter<ArticlesAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    var articulos = ArrayList<Article>()

    override fun getItemCount(): Int {
        return articulos.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_result, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val art = articulos[position]

        /*if (position % 2 == 0) {
            holder.itemView.setBackgroundColor(Color.parse("#CCCCCC"))
        } else {
            holder.itemView.setBackgroundColor(Color.parse("#FFFFFF"))
        }*/

        holder.itemView.prod1title.text = art.title
        holder.itemView.prod1price.text = "$${art.price}"

        Picasso.get()
            .load(art.thumbnail)
            .into(holder.itemView.prod1image)


        holder.itemView.setOnClickListener {

            val productId = art.id
            Log.e("Hola", productId)
            val intent = Intent(it.context, ProductActivity::class.java)

            intent.putExtra("productid", productId)

            it.context.startActivity(intent)
        }
    }
}