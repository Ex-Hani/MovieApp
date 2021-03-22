package com.example.easylearn.ui

import android.os.Bundle
import com.example.easylearn.R
import com.example.easylearn.presentation.MainPresenter
import com.example.easylearn.presentation.MainView
import dagger.hilt.android.AndroidEntryPoint
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

@AndroidEntryPoint
class MainActivity : MvpAppCompatActivity(), MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_main)
    }

    override fun setRootScreen() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, LoginFragment())
            .commit()
    }

    fun setTitle(title: String) {
        getSupportActionBar()?.setTitle(title);
    }
}
