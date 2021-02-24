package com.example.easylearn.entities

import com.google.gson.annotations.SerializedName

//TODO перепиши комменты на английском, ничего русского в коде быть не должно
// комменты должны начинаться с новой строчки и не мешать коду своим присутствием
data class OmdbResponse( //получаем список фильмов
    @SerializedName("Search") val search: List<OmdbMovie>,
    @SerializedName("totalResults") val totalResults: Int,
    @SerializedName("Response") val response: Boolean
)