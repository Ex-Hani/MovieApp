package com.example.easylearn.presentation

import com.example.easylearn.entities.OmdbMovieDetails
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip

interface CurrentMovieView : MvpView {

    @AddToEndSingle
    fun onMovieClicked(result: OmdbMovieDetails)

    @Skip
    fun showError()
}