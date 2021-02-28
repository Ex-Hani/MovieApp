package com.example.easylearn.ui.movieList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.easylearn.R
import com.example.easylearn.databinding.RecyclerviewItemBinding
import com.example.easylearn.entities.OmdbMovie

class MovieAdapter(
    private val context: Context,
    val onItemClick: ((
        items: List<OmdbMovie>?,
        position: Int
    ) -> Unit)? = null //in constructor get onItemClick or null
) : RecyclerView.Adapter<MovieHolder>() {

    lateinit var binding: RecyclerviewItemBinding

    var items: List<OmdbMovie>? = null
        set(value) {
            field = value
            //if data was changed -> reset
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieHolder {

        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recyclerview_item,
            parent,
            false
        )

        return object :
            MovieHolder(binding) {
            override fun onClick(v: View?) {
                onItemClick?.invoke(items, adapterPosition)
            }
        }
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        (holder).binding.recyclerMovieName.text = items?.get(position)?.title.toString()
        Glide.with(context)
            .load(items?.get(position)?.poster)
            .into((holder).binding.recyclerPoster)
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }
}