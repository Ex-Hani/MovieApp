package com.example.easylearn.presentation

import com.example.easylearn.entities.Movie
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip

interface MainView : MvpView {

    @Skip
    fun showMessage(msg: String)

    @AddToEndSingle
    fun setList(list: List<Movie>)
}
