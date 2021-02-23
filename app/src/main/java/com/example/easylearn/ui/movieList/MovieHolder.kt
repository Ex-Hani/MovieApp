package com.example.easylearn.ui.movieList

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.easylearn.databinding.RecyclerviewItemBinding

open class MovieHolder(
    val binding: RecyclerviewItemBinding
) : RecyclerView.ViewHolder(binding.root),
    View.OnClickListener { //наследуемся от OnClickListener

    init { //навешиваем listener
        binding.rootLayout.setOnClickListener {
            onClick(binding.rootLayout)
        }
    }

    //пустой метод для переопределения в будущем
    override fun onClick(v: View?) {

    }
}