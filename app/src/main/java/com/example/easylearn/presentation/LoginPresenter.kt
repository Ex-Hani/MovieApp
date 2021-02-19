package com.example.easylearn.presentation

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class LoginPresenter : MvpPresenter<LoginView>() {
    fun loginClick() {
        viewState.switchViews()
    }

    fun signClick(email: String, password: String) {
        if (email != "" && password != "")
            viewState.toMainScreen()
        else
            viewState.showMessage()
    }

}
