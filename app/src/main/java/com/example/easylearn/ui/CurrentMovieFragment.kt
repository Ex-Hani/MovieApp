package com.example.easylearn.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.easylearn.Data
import com.example.easylearn.R
import com.example.easylearn.databinding.FragmentCurrentMovieBinding
import com.example.easylearn.entities.OmdbMovieDetails
import com.example.easylearn.presentation.CurrentMoviePresenter
import com.example.easylearn.presentation.CurrentMovieView
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class CurrentMovieFragment : MvpAppCompatFragment(), CurrentMovieView {

    @InjectPresenter
    lateinit var presenter: CurrentMoviePresenter
    lateinit var binding: FragmentCurrentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_current_movie, container, false)
        presenter.loadMovieDetails(Data.imdbId)
        return binding.root
    }

    override fun showMovieData(result: OmdbMovieDetails) {
        binding.apply {
            Glide.with(this@CurrentMovieFragment)
                .load(result.poster)
                .into(currentMovieImagePoster)
            currentMovieTextTitle.text = result.title
            currentMovieTextYear.text = result.year.toString()
            currentMovieTextGenre.text = result.genre
            currentMovieTextDirector.text = result.director
            currentMovieTextPlot.text = result.plot
        }
        (activity as MainActivity).setTitle(result.title)
    }


    override fun showError() {
        activity.apply {
            Toast.makeText(this, getString(R.string.data_error), Toast.LENGTH_SHORT).show()
        }
    }
}