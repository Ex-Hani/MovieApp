package com.example.easylearn.model.repository

import android.util.Log
import com.example.easylearn.entities.OmdbMovie
import com.example.easylearn.entities.OmdbMovieDetails
import com.example.easylearn.model.db.MovieDao
import com.example.easylearn.model.db.MovieDetailsDao
import com.example.easylearn.model.server.ApiClient
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiClient: ApiClient,
    private val movieDao: MovieDao,
    private val movieDetailsDao: MovieDetailsDao
) : MovieRepository {

    override var imdbId: String = ""

    override suspend fun getMovies(search: String): List<OmdbMovie> {
        var result: List<OmdbMovie> = ArrayList<OmdbMovie>()

        try {
            result = apiClient.getMovies(search).search
            movieDao.insertList(result)
        } catch (e: Exception) {
            try {
                result = movieDao.getList()
            } catch (e: Exception) {
                Log.e("MovieRepository getMovies", e.toString())
            }
        }
        return result
    }

    override suspend fun loadMovieDetails(): OmdbMovieDetails? {
        var result: OmdbMovieDetails? = null

        try {
            result = apiClient.loadMovieDetails(imdbId)
            movieDetailsDao.insert(result)
        } catch (e: Exception) {
            try {
                result = movieDetailsDao.get(imdbId)
            } catch (e: Exception) {
                Log.e("MovieRepository loadMovieDetails", e.toString())
            }
        }
        return result
    }
}