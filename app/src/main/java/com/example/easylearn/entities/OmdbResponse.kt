package com.example.easylearn.entities

import com.google.gson.annotations.SerializedName

data class OmdbResponse( //получаем список фильмов
    @SerializedName("Search") val search: List<OmdbMovie>,
    @SerializedName("totalResults") val totalResults: Int,
    @SerializedName("Response") val response: Boolean
)