package com.example.easylearn.ui

import android.os.Bundle
import android.widget.Toast
import com.example.easylearn.ListAdapter
import com.example.easylearn.R
import com.example.easylearn.databinding.ActivityLoginBinding
import com.example.easylearn.entities.Movie
import com.example.easylearn.presentation.MainPresenter
import com.example.easylearn.presentation.MainView
import kotlinx.android.synthetic.main.activity_main.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter


class MainActivity : MvpAppCompatActivity(), MainView {
    @InjectPresenter
    lateinit var presenter: MainPresenter

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }

    override fun showMessage() {
        Toast.makeText(this, getString(R.string.start), Toast.LENGTH_SHORT).show()
    }

    override fun setAdapter(list: List<Movie>) {
        list_view.adapter = ListAdapter(this, list)
        list_view.setOnItemClickListener { parent, view, position, id ->
            presenter.onItemClicked(position)
        }
    }
}
