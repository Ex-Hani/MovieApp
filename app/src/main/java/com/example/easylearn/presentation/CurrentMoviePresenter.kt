package com.example.easylearn.presentation

import com.example.easylearn.model.repository.MovieRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class CurrentMoviePresenter @Inject constructor(
    private val movieRepository: MovieRepository
) : MvpPresenter<CurrentMovieView>(), CoroutineScope by CoroutineScope(
    Dispatchers.Main
) {

    fun loadMovieDetails() {
        launch {
            try {
                //create variable with result (data)
                val result =
                    movieRepository.loadMovieDetails()
                if (result != null && result.response)
                    viewState.showMovieData(result)
                else viewState.showError()
            } catch (e: Exception) {
                //show error
                e.printStackTrace()
                viewState.showError()
            }
        }
    }
}