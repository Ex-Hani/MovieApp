package com.example.easylearn.presentation

import com.example.easylearn.model.server.ApiAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class CurrentMoviePresenter : MvpPresenter<CurrentMovieView>(), CoroutineScope by CoroutineScope(
    Dispatchers.Main
) {

    fun loadMovieDetails(id: String) {
        launch {
            try {
                //create variable with result (data)
                val result =
                    ApiAdapter.apiClient.loadMovieDetails(imdbId = id)
                if (result.response)
                    viewState.onMovieClicked(result)
                else viewState.showError()
            } catch (e: Exception) {
                //show error
                e.printStackTrace()
                viewState.showError()
            }
        }
    }
}