package com.example.auth.viewmodel


sealed class RegisterState {
    data object Idle : RegisterState()
    data object Loading : RegisterState()
    data object Success : RegisterState()
    data class Fail(val message: String) : RegisterState()
    data object InvalidEmail : RegisterState()
    data object PasswordsMismatch : RegisterState()
    data object UserAlreadyExists : RegisterState()
}

sealed class LoginState {
    data object Idle : LoginState()
    data object Loading : LoginState()
    data object Success : LoginState()
    data class Fail(val message: String) : LoginState()
    data object WrongPassword : LoginState()
    data object NoUserFound : LoginState()
}