package com.example.domain.model.user

sealed class RegisterResult {
    data class Success(val response: AuthResponse) : RegisterResult()
    data class Failure(val message: String) : RegisterResult()
    data object UserAlreadyExists : RegisterResult() // 409 Conflict
    data object NonValidEmail : RegisterResult() // 400 Bad Request
    data class ServerError(val message: String) : RegisterResult() // 500 Internal Server Error
}