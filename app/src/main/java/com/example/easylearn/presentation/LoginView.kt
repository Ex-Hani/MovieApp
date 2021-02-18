package com.example.easylearn.presentation

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEnd
import moxy.viewstate.strategy.alias.Skip

interface LoginView : MvpView {
    @Skip
    fun showMessage()

    @Skip
    fun toMainScreen()

    @AddToEnd
    fun switchViews()
}