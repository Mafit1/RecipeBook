package com.example.domain.model.user

sealed class LoginResult {
    data class Success(val response: AuthResponse) : LoginResult()
    data object UserNotFound : LoginResult()
    data object InvalidPassword : LoginResult()
    data class Failure(val message: String) : LoginResult()
    data class ServerError(val message: String) : LoginResult() // 500 Internal Server Error
}