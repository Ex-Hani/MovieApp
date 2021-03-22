package com.example.easylearn.di

import android.content.Context
import androidx.room.Room
import com.example.easylearn.model.db.AppDatabase
import com.example.easylearn.model.db.MovieDao
import com.example.easylearn.model.db.MovieDetailsDao
import com.example.easylearn.model.repository.MovieRepository
import com.example.easylearn.model.repository.MovieRepositoryImpl
import com.example.easylearn.model.server.ApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        val database = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "AppDatabase"
        ).build()
        return database
    }

    @Singleton
    @Provides
    fun provideMovieDao(
        database: AppDatabase
    ): MovieDao {
        val movieDao: MovieDao = database.movieDao()
        return movieDao
    }

    @Singleton
    @Provides
    fun provideMovieDetailsDao(
        database: AppDatabase
    ): MovieDetailsDao {
        val movieDetailsDao: MovieDetailsDao = database.movieDetailsDao()
        return movieDetailsDao
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient =
        with(OkHttpClient.Builder()) {
            val cTimeout = 30L
            val rTimeout = 30L

            connectTimeout(cTimeout, TimeUnit.SECONDS)
            readTimeout(rTimeout, TimeUnit.SECONDS)


            addNetworkInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })

            build()
        }

    @Singleton
    @Provides
    fun provideApiService(httpClient: OkHttpClient): ApiClient {
        return Retrofit.Builder()
            .client(httpClient)
            .baseUrl("http://www.omdbapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiClient::class.java)
    }

    @Singleton
    @Provides
    fun provideMovieRepository(
        apiClient: ApiClient,
        movieDao: MovieDao,
        movieDetailsDao: MovieDetailsDao
    ): MovieRepository {
        return MovieRepositoryImpl(apiClient, movieDao, movieDetailsDao)
    }

    /*@Singleton
    @Provides
    fun provideMovieListPresenter(movieRepository: MovieRepository): MovieListPresenter {
        return MovieListPresenter(movieRepository)
    }

    @Singleton
    @Provides
    fun provideCurrentMoviePresenter(
        movieRepository: MovieRepository
    ): CurrentMoviePresenter {
        return CurrentMoviePresenter(movieRepository)
    }*/
}