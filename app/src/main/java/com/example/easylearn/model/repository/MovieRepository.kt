package com.example.easylearn.model.repository

import com.example.easylearn.entities.OmdbMovie
import com.example.easylearn.entities.OmdbMovieDetails

interface MovieRepository {

    var imdbId: String

    suspend fun getMovies(
        search: String
    ): List<OmdbMovie>

    suspend fun loadMovieDetails(): OmdbMovieDetails?
}