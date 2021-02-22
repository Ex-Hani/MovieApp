package com.example.easylearn.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.easylearn.Data
import com.example.easylearn.R
import com.example.easylearn.entities.OmdbMovieDetails
import com.example.easylearn.presentation.CurrentMoviePresenter
import com.example.easylearn.presentation.CurrentMovieView
import kotlinx.android.synthetic.main.activity_current_movie.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class CurrentMovieActivity : MvpAppCompatActivity(), CurrentMovieView {

    @InjectPresenter
    lateinit var presenter: CurrentMoviePresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_current_movie)
        presenter.loadMovieDetails(Data.imdbId)
    }

    override fun showMovieData(result: OmdbMovieDetails) {
        Glide.with(this)
            .load(result.poster)
            .into(current_movie_image_poster)
        current_movie_text_title.text = result.title
        current_movie_text_year.text = result.year.toString()
        current_movie_text_genre.text = result.genre
        current_movie_text_director.text = result.director
        current_movie_text_plot.text = result.plot
    }
}