package com.example.easylearn

import android.view.View
import androidx.recyclerview.widget.RecyclerView

open class MovieHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener { //наследуемся от OnClickListener

    init { //навешиваем listener
        itemView.setOnClickListener(this)
    }

    //пустой метод для переопределения в будущем
    override fun onClick(v: View?) {
        //for override
    }
}