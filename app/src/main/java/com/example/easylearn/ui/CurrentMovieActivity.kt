package com.example.easylearn.ui

import android.os.Bundle
import android.widget.Toast
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

    override fun onMovieClicked(result: OmdbMovieDetails) {
        binding.apply {
            Glide.with(this@CurrentMovieActivity)
                .load(result.poster)
                .into(currentMovieImagePoster)
            currentMovieTextTitle.text = result.title
            currentMovieTextYear.text = result.year.toString()
            currentMovieTextGenre.text = result.genre
            currentMovieTextDirector.text = result.director
            currentMovieTextPlot.text = result.plot
        }
    }

    override fun showError() {
        Toast.makeText(this, getString(R.string.data_error), Toast.LENGTH_SHORT).show()
    }
}