package com.example.easylearn

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.easylearn.entities.OmdbMovie
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class MovieAdapter(
    val context: Context,
    val onItemClick: ((items: List<OmdbMovie>?, position: Int) -> Unit)? = null //в конструкторе получаем метод onItemClick, либо null
) : RecyclerView.Adapter<MovieHolder>() {

    var items: List<OmdbMovie>? = null //список может быть - null
        set(value) {
            field = value
            notifyDataSetChanged() //если данные изменились, список автоматически будет обновляться
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieHolder { // метод вызывается при создании ViewHolder
        val v = LayoutInflater.from(parent.context).inflate(
            R.layout.recyclerview_item,
            parent,
            false
        ) // передаём переменной xml элемента списка
        return object :
            MovieHolder(v) { //при привязке Holdera переопределяем его onClick и записываем туда свой Unit
            override fun onClick(v: View?) {
                onItemClick?.invoke(items, adapterPosition)
            }
        }
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        (holder).itemView.name.setText(items?.get(position)?.title.toString()) //крепим наши данные из items в xml layout
        Glide.with(context)
            .load(items?.get(position)?.poster)
            .into((holder).itemView.img)
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0 //сколько элементов отобразить ?
    }
}