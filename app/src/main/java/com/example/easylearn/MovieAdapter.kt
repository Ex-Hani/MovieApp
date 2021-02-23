package com.example.easylearn

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.easylearn.databinding.RecyclerviewItemBinding
import com.example.easylearn.entities.OmdbMovie

class MovieAdapter(
    val context: Context,
    val onItemClick: ((items: List<OmdbMovie>?, position: Int) -> Unit)? = null //в конструкторе получаем метод onItemClick, либо null
) : RecyclerView.Adapter<MovieHolder>() {

    lateinit var binding: RecyclerviewItemBinding

    var items: List<OmdbMovie>? = null //список может быть - null
        set(value) {
            field = value
            notifyDataSetChanged() //если данные изменились, список автоматически будет обновляться
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieHolder { // метод вызывается при создании ViewHolder

        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recyclerview_item,
            parent,
            false
        )

        return object :
            MovieHolder(binding) { //при привязке Holdera переопределяем его onClick и записываем туда свой Unit
            override fun onClick(v: View?) {
                onItemClick?.invoke(items, adapterPosition)
            }
        }
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        (holder).binding.name.text = items?.get(position)?.title.toString()
        Glide.with(context)
            .load(items?.get(position)?.poster)
            .into((holder).binding.img)
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0 //сколько элементов отобразить ?
    }
}