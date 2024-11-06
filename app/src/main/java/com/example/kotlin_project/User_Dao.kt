package com.example.kotlin_project

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface User_Dao
{
    @Insert
    suspend fun insert(user: User)

    @Query("Select * from user")
    suspend fun getAllUser():List<User>

}