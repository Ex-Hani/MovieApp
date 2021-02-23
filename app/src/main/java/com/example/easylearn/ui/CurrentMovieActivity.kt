package com.example.easylearn.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.easylearn.Data
import com.example.easylearn.R
import com.example.easylearn.databinding.ActivityCurrentMovieBinding
import com.example.easylearn.entities.OmdbMovieDetails
import com.example.easylearn.presentation.CurrentMoviePresenter
import com.example.easylearn.presentation.CurrentMovieView
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class CurrentMovieActivity : MvpAppCompatActivity(), CurrentMovieView {

    @InjectPresenter
    lateinit var presenter: CurrentMoviePresenter
    lateinit var binding: ActivityCurrentMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_current_movie)
        presenter.loadMovieDetails(Data.imdbId)
    }

    override fun showMovieData(result: OmdbMovieDetails) {
        Glide.with(this)
            .load(result.poster)
            .into(binding.currentMovieImagePoster)
        binding.currentMovieTextTitle.text = result.title
        binding.currentMovieTextYear.text = result.year.toString()
        binding.currentMovieTextGenre.text = result.genre
        binding.currentMovieTextDirector.text = result.director
        binding.currentMovieTextPlot.text = result.plot
    }
}