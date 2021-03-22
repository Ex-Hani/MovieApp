package com.example.easylearn.presentation

import com.example.easylearn.entities.OmdbMovie
import com.example.easylearn.model.repository.MovieRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class MovieListPresenter @Inject constructor(
    private val movieRepository: MovieRepository
) : MvpPresenter<MovieListView>(), CoroutineScope by CoroutineScope(
    Dispatchers.Main
) {

    fun onItemClicked(items: List<OmdbMovie>?, position: Int) {
        movieRepository.imdbId = items?.get(position)?.imdbID ?: ""
        viewState.toCurrentMovie()
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadList("joker")
    }

    private fun loadList(search: String) {
        launch {
            try {
                val result =
                    movieRepository.getMovies(search = search)
                //showing the list with data
                if (result.size > 0)
                    viewState.setList(result)
                else viewState.showError()
            } catch (e: Exception) {
                //or showing error
                e.printStackTrace()
                viewState.showError()
            }
        }
    }

    fun onSearchClicked(toString: String) {
        loadList(toString)
    }
}