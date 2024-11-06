package com.example.kotlin_project

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDataBase:RoomDatabase()
{
    abstract fun userDao():User_Dao
}