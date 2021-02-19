package com.example.easylearn.presentation

import com.example.easylearn.MockData.movies
import com.example.easylearn.entities.Movie
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class MovieListPresenter : MvpPresenter<MovieListView>() {

    fun onItemClicked(items: List<Movie>?, position: Int) {
        viewState.showMessage(items?.get(position)?.title ?: "")
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.setList(movies)
    }
}