package com.example.easylearn.presentation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.v12ten.retrofittests.model.server.ApiAdapter
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class CurrentMoviePresenter : MvpPresenter<CurrentMovieView>(), CoroutineScope by CoroutineScope(
    Dispatchers.Main
) {

    fun loadMovieDetails(id: String) {
        launch {
            try {
                //TODO добавь проверку на поле response (пришел ли корректный ответ)
                // и выводи ошибки на viewState разные (если эксепшн и если response false)
                // ВЕЗДЕ
                val result =
                    ApiAdapter.apiClient.loadMovieDetails(imdbId = id) //объявляем переменную которая будет получать список нужных нам данных
                viewState.showMovieData(result)
            } catch (e: Exception) {
                e.printStackTrace() //или показываем ошибку
            }
        }
    }
}