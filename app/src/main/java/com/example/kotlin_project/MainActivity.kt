package com.example.kotlin_project

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var userviewmodel:UserViewModel
    private lateinit var et_name:EditText
    private lateinit var et_email:EditText
    private lateinit var et_password:EditText
    private lateinit var et_mobile:EditText
    private lateinit var bt_Save: Button
    private lateinit var txt_name: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        userviewmodel = ViewModelProvider(this).get(UserViewModel::class.java)
        et_name = findViewById(R.id.et_name)
        et_email = findViewById(R.id.et_email)
        et_password = findViewById(R.id.et_password)
        et_mobile = findViewById(R.id.et_mobile)
        bt_Save = findViewById(R.id.bt_save)
        txt_name = findViewById(R.id.txt_user_name)

        bt_Save.setOnClickListener()
        {
            var name = et_name.text.toString()
            var email = et_email.text.toString()
            var password = et_password.text.toString()
            var mobile = et_mobile.text.toString()

            var user = User(name = name, email = email, password = password, mobile = mobile)
            userviewmodel.insert(user)
            Toast.makeText(this@MainActivity,"Save Record",Toast.LENGTH_LONG).show()
        }





        userviewmodel.users.observe(this, Observer { users ->
                txt_name.text = users.toString()
        })

        // Fetch users
        userviewmodel.getUsers()
    }
}