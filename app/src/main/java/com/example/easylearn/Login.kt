package com.example.easylearn

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val login_btn = findViewById<Button>(R.id.login)
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val sing_btn = findViewById<Button>(R.id.sign)
        val login_facebook = findViewById<Button>(R.id.facebook)

        email.visibility = View.GONE
        password.visibility = View.GONE
        sing_btn.visibility = View.GONE
        login_facebook.visibility = View.GONE
        login_btn.setOnClickListener {
            val main_title = findViewById<TextView>(R.id.description)
            val free_btn = findViewById<Button>(R.id.free)

            main_title.visibility = View.GONE
            free_btn.visibility = View.GONE
            login_btn.visibility = View.GONE

            if (main_title.visibility == View.GONE) {
                email.visibility = View.VISIBLE
                password.visibility = View.VISIBLE
                sing_btn.visibility = View.VISIBLE
                login_facebook.visibility = View.VISIBLE
            }
        }
        sing_btn.setOnClickListener{
            val email_value = email.text.toString()
            val passord_value = password.text.toString()
            if (email_value != "" && passord_value != ""){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                val text = "Введите данные!"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
            }
        }
    }
}
