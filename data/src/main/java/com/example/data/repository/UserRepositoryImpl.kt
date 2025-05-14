package com.example.data.repository

import com.example.data.remote.UserAPI
import com.example.domain.model.user.LoginRequest
import com.example.domain.model.user.LoginResult
import com.example.domain.model.user.RegisterRequest
import com.example.domain.model.user.RegisterResult
import com.example.domain.repository.UserRepository
import java.io.IOException

class UserRepositoryImpl(
    private val api: UserAPI
): UserRepository {
    override suspend fun registerUser(email: String, password: String): RegisterResult {
        return try {
            val response = api.register(RegisterRequest(email = email, password = password))
            when (response.code()) {
                200 -> RegisterResult.Success(response.body()!!)
                400 -> RegisterResult.NonValidEmail
                409 -> RegisterResult.UserAlreadyExists
                500 -> RegisterResult.ServerError(response.errorBody()?.string() ?: "Server error")
                else -> RegisterResult.Failure("Unexpected response: ${response.code()}")
            }
        } catch (e: IOException) {
            RegisterResult.Failure("Network error: ${e.message}")
        } catch (e: Exception) {
            RegisterResult.Failure("Unexpected error: ${e.message}")
        }
    }

    override suspend fun loginUser(email: String, password: String): LoginResult {
        return try {
            val response = api.login(LoginRequest(email = email, password = password))
            return when (response.code()) {
                200 -> LoginResult.Success(response.body()!!)
                404 -> LoginResult.UserNotFound
                403 -> LoginResult.InvalidPassword
                500 -> LoginResult.ServerError(response.errorBody()?.string() ?: "Server error")
                else -> LoginResult.Failure("Unexpected response: ${response.code()}")
            }
        } catch (e: IOException) {
            LoginResult.Failure("Network error: ${e.message}")
        } catch (e: Exception) {
            LoginResult.Failure("Unexpected error: ${e.message}")
        }
    }
}