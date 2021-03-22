package com.example.easylearn.model.db

import androidx.room.*
import com.example.easylearn.entities.OmdbMovieDetails

@Dao
interface MovieDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(list: OmdbMovieDetails)

    @Transaction
    @Query("select * from OmdbMovieDetails where :imdbID = imdbID ")
    suspend fun get(imdbID: String): OmdbMovieDetails

    @Transaction
    @Query("delete from OmdbMovieDetails")
    suspend fun clearList()
}
