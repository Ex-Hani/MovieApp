package com.example.easylearn.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.easylearn.Data
import com.example.easylearn.MovieAdapter
import com.example.easylearn.R
import com.example.easylearn.entities.OmdbMovie
import com.example.easylearn.presentation.MovieListPresenter
import com.example.easylearn.presentation.MovieListView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_movie_list.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class MovieListActivity : MvpAppCompatActivity(), MovieListView {

    @InjectPresenter
    lateinit var presenter: MovieListPresenter
    lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        adapter = MovieAdapter(this, onItemClick = { items: List<OmdbMovie>?, position: Int ->
            Log.d("__lal", "OnClicked ${Gson().toJson(items?.get(position))}")
            presenter.onItemClicked(items, position)
        })
        movie_list_button_search.setOnClickListener {
            presenter.onSearchClicked(movie_list_edit_search.text.toString())
        }
        movie_list_recycler_movies.layoutManager = LinearLayoutManager(this)
        movie_list_recycler_movies.adapter = adapter
    }

    override fun toCurrentMovie(id: String) {
        Log.d("__lal", "To Movie ${id}")
        Data.imdbId = id
        intent = Intent(this, CurrentMovieActivity::class.java)
        startActivity(intent)
    }

    override fun setList(list: List<OmdbMovie>) {
        adapter.items = list
    }
}
