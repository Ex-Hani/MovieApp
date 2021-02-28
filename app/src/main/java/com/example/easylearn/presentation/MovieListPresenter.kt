package com.example.easylearn.presentation

import com.example.easylearn.entities.OmdbMovie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.easylearn.model.server.ApiAdapter
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class MovieListPresenter : MvpPresenter<MovieListView>(), CoroutineScope by CoroutineScope(
    Dispatchers.Main
) {

    fun onItemClicked(items: List<OmdbMovie>?, position: Int) {
        viewState.toCurrentMovie(items?.get(position)?.imdbID ?: "")
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadList("joker")
    }

    private fun loadList(search: String) {
        launch {
            try {
                val result =
                    ApiAdapter.apiClient.getMovies(search = search)
                //showing the list with data
                if (result.response)
                viewState.setList(result.search)
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