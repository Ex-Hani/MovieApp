package com.example.easylearn.presentation

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip

interface LoginView : MvpView {

    @Skip
    fun showMessageError()

    @Skip
    fun toMainScreen()
}
