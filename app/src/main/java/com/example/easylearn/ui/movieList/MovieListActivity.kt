package com.example.easylearn.ui.movieList

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.easylearn.Data
import com.example.easylearn.R
import com.example.easylearn.databinding.ActivityMovieListBinding
import com.example.easylearn.entities.OmdbMovie
import com.example.easylearn.presentation.MovieListPresenter
import com.example.easylearn.presentation.MovieListView
import com.example.easylearn.ui.CurrentMovieActivity
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class MovieListActivity : MvpAppCompatActivity(), MovieListView {

    @InjectPresenter
    lateinit var presenter: MovieListPresenter
    lateinit var adapter: MovieAdapter
    lateinit var binding: ActivityMovieListBinding

    //TODO после super тоже оставляй одну строчку пустую - так немножко читабельнее будет
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_list)

        adapter = MovieAdapter(this, onItemClick = { items: List<OmdbMovie>?, position: Int ->
            presenter.onItemClicked(items, position)
        })
        binding.movieListButtonSearch.setOnClickListener {
            presenter.onSearchClicked(binding.movieListEditSearch.text.toString())
        }
        binding.movieListRecyclerMovies.layoutManager = LinearLayoutManager(this)
        binding.movieListRecyclerMovies.adapter = adapter
    }

    override fun toCurrentMovie(id: String) {
        Data.imdbId = id
        intent = Intent(this, CurrentMovieActivity::class.java)
        startActivity(intent)
    }

    override fun setList(list: List<OmdbMovie>) {
        adapter.items = list
    }
}
