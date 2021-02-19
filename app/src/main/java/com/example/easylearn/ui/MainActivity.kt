package com.example.easylearn.ui

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.easylearn.MovieAdapter
import com.example.easylearn.R
import com.example.easylearn.entities.Movie
import com.example.easylearn.presentation.MainPresenter
import com.example.easylearn.presentation.MainView
import kotlinx.android.synthetic.main.activity_main.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter
    lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = MovieAdapter(onItemClick = { items: List<Movie>?, position: Int ->
            presenter.onItemClicked(items, position)
        })
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, String.format(getString(R.string.start), msg), Toast.LENGTH_SHORT)
            .show()
    }

    override fun setList(list: List<Movie>) {
        adapter.items = list
    }
}
