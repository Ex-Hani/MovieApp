package com.example.easylearn.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.easylearn.R
import com.example.easylearn.databinding.ActivityLoginBinding
import com.example.easylearn.presentation.LoginPresenter
import com.example.easylearn.presentation.LoginView
import com.example.easylearn.ui.movieList.MovieListActivity
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class LoginActivity : MvpAppCompatActivity(), LoginView {

    @InjectPresenter
    lateinit var presenter: LoginPresenter
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.login.setOnClickListener {
            presenter.loginClick()
        }
        binding.sign.setOnClickListener {
            presenter.signClick(binding.email.text.toString(), binding.password.text.toString())
        }
    }

    override fun showMessage() {
        Toast.makeText(this, getString(R.string.error), Toast.LENGTH_SHORT).show()
    }

    override fun switchViews() {
        binding.description.visibility = View.GONE
        binding.free.visibility = View.GONE
        binding.login.visibility = View.GONE
        binding.email.visibility = View.VISIBLE
        binding.password.visibility = View.VISIBLE
        binding.sign.visibility = View.VISIBLE
        binding.facebook.visibility = View.VISIBLE
    }

    override fun toMainScreen() {
        val intent = Intent(this, MovieListActivity::class.java)
        startActivity(intent)

    }
}
