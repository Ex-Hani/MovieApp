package com.example.easylearn

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login.setOnClickListener {
            loginClick()
        }
        sign.setOnClickListener {
            signClick()
        }
    }

    private fun loginClick() {
        description.visibility = View.GONE
        free.visibility = View.GONE
        login.visibility = View.GONE
        email.visibility = View.VISIBLE
        password.visibility = View.VISIBLE
        sign.visibility = View.VISIBLE
        facebook.visibility = View.VISIBLE
    }

    private fun signClick() {
        if (email.text.toString() != "" && password.text.toString() != "") {
            toMainScreen()
        } else {
            showToast(getString(R.string.error), Toast.LENGTH_SHORT)
        }
    }

    private fun showToast(msg: String, duration: Int) {
        val toast = Toast.makeText(this, msg, duration)
        toast.show()
    }

    private fun toMainScreen() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }

}
