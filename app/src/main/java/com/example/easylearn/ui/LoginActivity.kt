package com.example.easylearn.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.easylearn.R
import com.example.easylearn.presentation.LoginPresenter
import com.example.easylearn.presentation.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class LoginActivity : MvpAppCompatActivity(), LoginView {
    @InjectPresenter
    lateinit var presenter: LoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login.setOnClickListener {
            presenter.loginClick()
        }
        sign.setOnClickListener {
            presenter.signClick(email.text.toString(), password.text.toString())
        }
    }


    override fun showMessage() {
        Toast.makeText(this, getString(R.string.error), Toast.LENGTH_SHORT).show()
    }


    override fun switchViews() {
        description.visibility = View.GONE
        free.visibility = View.GONE
        login.visibility = View.GONE
        email.visibility = View.VISIBLE
        password.visibility = View.VISIBLE
        sign.visibility = View.VISIBLE
        facebook.visibility = View.VISIBLE
    }

    override fun toMainScreen() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }
}
