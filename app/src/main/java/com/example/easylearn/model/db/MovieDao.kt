package com.example.easylearn.model.db

import androidx.room.*
import com.example.easylearn.entities.OmdbMovie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertList(list: List<OmdbMovie>)

    @Transaction
    @Query("select * from OmdbMovie")
    suspend fun getList(): List<OmdbMovie>


    @Transaction
    @Query("delete from OmdbMovie")
    suspend fun clearList()
}
