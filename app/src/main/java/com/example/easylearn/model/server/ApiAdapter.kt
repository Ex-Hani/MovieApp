package me.v12ten.retrofittests.model.server

import com.example.easylearn.model.server.ApiClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiAdapter { //создаём адаптер АПИ
    val logging = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    val apiClient: ApiClient = Retrofit.Builder()
        .baseUrl("http://www.omdbapi.com") //при работе меняем url на свой, с которого необходимо получить данные
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiClient::class.java)
}