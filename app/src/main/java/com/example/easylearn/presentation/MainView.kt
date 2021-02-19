package com.example.easylearn.presentation

import moxy.MvpView
import moxy.viewstate.strategy.alias.Skip

interface MainView : MvpView {
    @Skip
    fun showMessage()

}
