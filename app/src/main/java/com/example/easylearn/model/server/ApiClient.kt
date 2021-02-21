package com.example.easylearn.model.server

import com.example.easylearn.entities.OmdbMovieDetails
import com.example.easylearn.entities.OmdbResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient { //создаём интерфейс клиента АПИ
    @GET("/") //запрос
    suspend fun getMovies(
        @Query("s") search: String = "game",
        @Query("apikey") apikey: String = "9c8e835c"
    ): OmdbResponse //функция которая получает данные

    @GET("/")
    suspend fun loadMovieDetails(
        @Query("i") imdbId: String,
        @Query("apikey") apikey: String = "9c8e835c"
    ): OmdbMovieDetails
}