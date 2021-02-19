package com.example.easylearn

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.easylearn.entities.Movie
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class MovieAdapter(
    val onItemClick: ((items: List<Movie>?, position: Int) -> Unit)? = null //в конструкторе получаем метод onItemClick, либо null
) : RecyclerView.Adapter<MovieHolder>() {

    var items: List<Movie>? = null
        set(value) {
            field = value
            notifyDataSetChanged() //при любом изменении items обновлять ВСЕ элементы recyclerview
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val v = LayoutInflater //рендерим вьюху по твоей xml
            .from(parent.context)
            .inflate(R.layout.recyclerview_item, parent, false)

        return object :
            MovieHolder(v) { //при привязке Holdera переопределяем его onClick и записываем туда свой Unit
            override fun onClick(v: View?) {
                onItemClick?.invoke(items, adapterPosition)
            }
        }
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        (holder).itemView.name.setText(items?.get(position)?.title.toString()) //крепим наши данные из items в реальную xml вьюху
        (holder).itemView.img.setImageResource(items?.get(position)?.image ?: 0)
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0 //сколько элементов отобразить ?
    }
}