package com.example.easylearn.entities

import com.google.gson.annotations.SerializedName

data class OmdbMovie(

        @SerializedName("Title") val title: String,
        @SerializedName("Year") val year: String,
        @SerializedName("imdbID") val imdbID: String,
        @SerializedName("Type") val type: String,
        @SerializedName("Poster") val poster: String

)