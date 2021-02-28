package com.example.easylearn.ui.movieList

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.easylearn.databinding.RecyclerviewItemBinding

open class MovieHolder(
    val binding: RecyclerviewItemBinding
) : RecyclerView.ViewHolder(binding.root),
    View.OnClickListener {

    init {
        binding.rootLayout.setOnClickListener {
            onClick(binding.rootLayout)
        }
    }

    override fun onClick(v: View?) {

    }
}