package com.example.easylearn.ui

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.easylearn.MovieAdapter
import com.example.easylearn.R
import com.example.easylearn.entities.OmdbMovie
import com.example.easylearn.presentation.MovieListPresenter
import com.example.easylearn.presentation.MovieListView
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
            presenter.onItemClicked(items, position)
        })
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, String.format(getString(R.string.start), msg), Toast.LENGTH_SHORT)
            .show()
    }

    override fun setList(list: List<OmdbMovie>) {
        adapter.items = list
    }
}
