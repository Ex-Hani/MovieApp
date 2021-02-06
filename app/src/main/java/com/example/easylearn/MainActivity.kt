package com.example.easylearn

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val title = arrayOf<String>(
        "Jumanji: The Next Level",
        "Black Panther",
        "Mulan",
        "Black Widow",
        "Wonder Woman 1984",
        "X-men: Dark Phoenix",
        "Captain Marvel",
        "MA"
        )
    private val image = arrayOf<Int>(
        R.drawable.jumanji,
        R.drawable.black_panther,
        R.drawable.mulan,
        R.drawable.black_widow,
        R.drawable.ww,
        R.drawable.x_men,
        R.drawable.marvel,
        R.drawable.ma
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.decorView.apply {

            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_FULLSCREEN
        }
        setContentView(R.layout.activity_main)

        list_view.adapter = ListAdapter(this, image, title)
        list_view.setOnItemClickListener { parent, view, position, id ->

            if (position == 0) {

                Toast.makeText(this, "Start a movie", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
