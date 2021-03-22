package com.example.easylearn.model.server

import com.example.easylearn.entities.OmdbMovieDetails
import com.example.easylearn.entities.OmdbResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

//create API interface
interface ApiClient {

    //ur request
    @GET("/")
    suspend fun getMovies(
        @Query("s") search: String = "game",
        @Query("apikey") apikey: String = "8c28da5d"
//    Function get data
    ): OmdbResponse

    @GET("/")
    suspend fun loadMovieDetails(
        @Query("i") imdbId: String,
        @Query("apikey") apikey: String = "8c28da5d"
    ): OmdbMovieDetails

//    @GET("/Search/{apikey}/{search}")
//    suspend fun getMovies(
//        @Path("search") search: String = "game",
//        @Path("apikey") apikey: String = "k_lb15hh44"
////    Function get data
//    ): OmdbResponse
//
//    @GET("/")
//    suspend fun loadMovieDetails(
//        @Query("i") imdbId: String,
//        @Query("apikey") apikey: String = "k_lb15hh44"
//    ): OmdbMovieDetails
}