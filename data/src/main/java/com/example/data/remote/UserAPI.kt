package com.example.data.remote

import com.example.domain.model.user.AuthResponse
import com.example.domain.model.user.LoginRequest
import com.example.domain.model.user.RegisterRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserAPI {

    @POST("register")
    suspend fun register(@Body request: RegisterRequest): Response<AuthResponse>

    @POST("login")
    suspend fun login(@Body request: LoginRequest): Response<AuthResponse>
}