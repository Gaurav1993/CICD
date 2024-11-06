package com.example.kotlin_project

import javax.inject.Inject

class UserRepository @Inject constructor(var userDao: User_Dao)
{
    suspend fun getAlluser()= userDao.getAllUser()

    suspend fun insert(user: User)
    {
        userDao.insert(user)
    }
}
