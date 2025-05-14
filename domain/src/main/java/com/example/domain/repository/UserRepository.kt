package com.example.domain.repository

import com.example.domain.model.user.LoginResult
import com.example.domain.model.user.RegisterResult

interface UserRepository {

    suspend fun registerUser(email: String, password: String) : RegisterResult

    suspend fun loginUser(email: String, password: String) : LoginResult
}
