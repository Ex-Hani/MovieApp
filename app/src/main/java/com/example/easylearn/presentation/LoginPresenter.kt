package com.example.easylearn.presentation

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import moxy.InjectViewState
import moxy.MvpPresenter
//TODO используй reformat (ctrl+alt+l) а то у тебя еще и импорты неиспользуемые есть, это ж ппц
@InjectViewState
class LoginPresenter : MvpPresenter<LoginView>() {
    //TODO раскидай приветствие и авторизацию на 2 разных экрана, или продумай как-то логику в целом
    // то что у тебя вьюхи переключаются не есть хорошо, это решается фрагментами и ты типа спалишься что их не знаешь
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
