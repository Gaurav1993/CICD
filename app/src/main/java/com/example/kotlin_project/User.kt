package com.example.kotlin_project

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class User(
    @PrimaryKey(autoGenerate = true)  var id:Long = 0,
    var name:String,
    var email:String,
    var password:String,
    var mobile:String)
