package com.example.easylearn.entities

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class OmdbMovie(
        @SerializedName("Title")
        val title: String,
        @SerializedName("Year")
        val year: String,
        @SerializedName("imdbID")
        @PrimaryKey
        @NonNull
        val imdbID: String,
        @SerializedName("Type")
        val type: String,
        @SerializedName("Poster")
        val poster: String
)