package com.example.kotlin_project

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule
{
    @Provides
    @Singleton
    fun provideAppDatabase(app:Application):AppDataBase
    {
        return Room.databaseBuilder(app,AppDataBase::class.java,"app_database").build()
    }
    @Provides
    fun provideUserDao(appDatabase: AppDataBase): User_Dao {
        return appDatabase.userDao()
    }

    @Provides
    fun provideUserRepository(userDao: User_Dao): UserRepository {
        return UserRepository(userDao)
    }
}