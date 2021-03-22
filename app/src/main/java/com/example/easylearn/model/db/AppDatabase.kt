package com.example.easylearn.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.easylearn.entities.OmdbMovie
import com.example.easylearn.entities.OmdbMovieDetails

//init database and add classes for working with database
@Database(
    entities = [
        OmdbMovie::class,
        OmdbMovieDetails::class
    ], version = 1, exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun movieDetailsDao():MovieDetailsDao

}
