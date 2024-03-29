package com.example.easylearn.presentation

import com.example.easylearn.entities.OmdbMovie
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip

interface MovieListView : MvpView {

    @Skip
    fun toCurrentMovie()

    @AddToEndSingle
    fun setList(list: List<OmdbMovie>)

    @Skip
    fun showError()
}
