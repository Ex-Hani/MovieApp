package com.example.easylearn.presentation

import com.example.easylearn.MockData.movies
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {
    fun onItemClicked(position: Int) {
        if (position == 0) {
            viewState.showMessage()
        }
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setAdapter(movies)
    }
}