package com.example.easylearn.presentation

import com.example.easylearn.entities.OmdbMovieDetails
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip

interface CurrentMovieView : MvpView {

    @AddToEndSingle
    fun showMovieData(result: OmdbMovieDetails)

    @Skip
    fun showError()

}