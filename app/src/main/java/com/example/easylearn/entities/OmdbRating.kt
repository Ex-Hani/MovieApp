package com.example.easylearn.entities

import com.google.gson.annotations.SerializedName

data class OmdbRating(

    @SerializedName("Source") val source: String,
    @SerializedName("Value") val value: String

)