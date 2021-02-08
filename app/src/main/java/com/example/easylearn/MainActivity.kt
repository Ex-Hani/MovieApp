package com.example.easylearn

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_FULLSCREEN
        }
        setContentView(R.layout.activity_main)

        list_view.adapter = ListAdapter(this, MockData.movies)
        list_view.setOnItemClickListener { parent, view, position, id ->
            if (position == 0) {
                Toast.makeText(this, getString(R.string.start), Toast.LENGTH_SHORT).show()
            }
        }
    }
}
