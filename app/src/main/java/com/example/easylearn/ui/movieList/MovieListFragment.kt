package com.example.easylearn.ui.movieList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.easylearn.Data
import com.example.easylearn.R
import com.example.easylearn.databinding.FragmentMovieListBinding
import com.example.easylearn.entities.OmdbMovie
import com.example.easylearn.presentation.MovieListPresenter
import com.example.easylearn.presentation.MovieListView
import com.example.easylearn.ui.CurrentMovieFragment
import com.example.easylearn.ui.LoginFragment
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class MovieListFragment : MvpAppCompatFragment(), MovieListView {

    @InjectPresenter
    lateinit var presenter: MovieListPresenter
    lateinit var adapter: MovieAdapter
    lateinit var binding: FragmentMovieListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_list, container, false)

        adapter =
            MovieAdapter(requireContext(), onItemClick = { items: List<OmdbMovie>?, position: Int ->
                presenter.onItemClicked(items, position)
            })
        binding.movieListButtonSearch.setOnClickListener {
            presenter.onSearchClicked(binding.movieListEditSearch.text.toString())
        }
        binding.movieListRecyclerMovies.layoutManager = LinearLayoutManager(requireContext())
        binding.movieListRecyclerMovies.adapter = adapter
        return binding.root
    }

    override fun toCurrentMovie(id: String) {
        Data.imdbId = id
        activity?.apply {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, CurrentMovieFragment())
                .commit()
        }
    }

    override fun setList(list: List<OmdbMovie>) {
        adapter.items = list
    }

    override fun showError() {
        activity.apply {
            Toast.makeText(this, getString(R.string.data_error), Toast.LENGTH_SHORT).show()
        }
    }
}
