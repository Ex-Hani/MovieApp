package com.example.easylearn.entities

import com.google.gson.annotations.SerializedName

data class OmdbResponse(
//    get movies list
    @SerializedName("Search") val search: List<OmdbMovie>,
    @SerializedName("totalResults") val totalResults: Int,
    @SerializedName("Response") val response: Boolean

)