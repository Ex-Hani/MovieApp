package com.example.easylearn.ui

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easylearn.MockData
import com.example.easylearn.MovieAdapter
import com.example.easylearn.R
import com.example.easylearn.databinding.ActivityLoginBinding
import com.example.easylearn.entities.Movie
import com.example.easylearn.presentation.MainPresenter
import com.example.easylearn.presentation.MainView
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter


class MainActivity : MvpAppCompatActivity(), MainView {
    @InjectPresenter
    lateinit var presenter: MainPresenter
    lateinit var adapter: MovieAdapter //твой адаптер для дальнейшей работы
    val items: ArrayList<Movie> = ArrayList() //список чего-либо (можешь брать откуда угодно)
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    override fun showMessage() {
        Toast.makeText(this, getString(R.string.start), Toast.LENGTH_SHORT).show()
    }
}
