package com.example.easylearn

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.easylearn.MockData.movies

class ListAdapter(
    private val context: Context,
    var movie: Array<Movie>
) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var view: View? = convertView
        val viewHolder: ViewHolder

        if (view == null) {
            viewHolder = ViewHolder()
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.list_item, null, true)

            viewHolder.name = view.findViewById(R.id.name)
            viewHolder.image = view.findViewById(R.id.img)

            view.tag = viewHolder
        } else {
            viewHolder = view.tag as ViewHolder
        }

        viewHolder.name?.text = movies[position].title
        viewHolder.image?.setImageResource(movies[position].image)

        return view
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return movies.size
    }

    private inner class ViewHolder {
        var name: TextView? = null
        var image: ImageView? = null
    }
}