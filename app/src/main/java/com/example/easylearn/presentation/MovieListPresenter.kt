package com.example.easylearn.presentation

import android.util.Log
import com.example.easylearn.entities.OmdbMovie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.v12ten.retrofittests.model.server.ApiAdapter
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class MovieListPresenter : MvpPresenter<MovieListView>(), CoroutineScope by CoroutineScope(
    Dispatchers.Main
) {
//TODO убрать лишние логи, либо сделать их "красивыми" с тегом и все такое
    fun onItemClicked(items: List<OmdbMovie>?, position: Int) {
        Log.d("__lal", "onItemClicked ${items?.get(position)?.imdbID}")
        viewState.toCurrentMovie(items?.get(position)?.imdbID ?: "")
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
            //TODO продумай логику первого запуска тоже, что показывать при входе?
        loadList("batman") //вызываем функцию загрузки списка
    }

    private fun loadList(search: String) { //функция загружает список
        launch {
            try {
                val result =
                    ApiAdapter.apiClient.getMovies(search = search) //объявляем переменную которая будет получать список нужных нам данных
                viewState.setList(result.search) // показываем список данных
            } catch (e: Exception) {
                e.printStackTrace() //или показываем ошибку
            }
        }
    }

    fun onSearchClicked(toString: String) {
        loadList(toString)
    }
}