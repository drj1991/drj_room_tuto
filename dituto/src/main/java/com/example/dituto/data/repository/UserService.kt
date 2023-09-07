package com.example.dituto.data.repository

import android.util.Log

class UserService {

    fun saveUser(name: String, email: String){
        Log.d("DRJ", "User($name, $email) is created")
    }
}