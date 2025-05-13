package com.example.auth.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.user.LoginResult
import com.example.domain.model.user.RegisterResult
import com.example.domain.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AuthViewModel(
    private val userRepository: UserRepository
) : ViewModel() {
    private val _registerState = MutableStateFlow<RegisterState>(RegisterState.Idle)
    val registerState = _registerState.asStateFlow()

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState = _loginState.asStateFlow()

    fun signIn(email: String, password: String) = viewModelScope.launch {
        _loginState.value = LoginState.Loading
        try {
            val result = userRepository.loginUser(
                email = email,
                password = password
            )
            when (result){
                is LoginResult.Failure -> _loginState.value = LoginState.Fail(result.message)
                LoginResult.InvalidPassword -> _loginState.value = LoginState.WrongPassword
                is LoginResult.ServerError -> _loginState.value = LoginState.Fail("Server error")
                is LoginResult.Success -> _loginState.value = LoginState.Success
                LoginResult.UserNotFound -> _loginState.value = LoginState.NoUserFound
            }
        } catch (e: Exception) {
            _loginState.value = LoginState.Fail("Unknown error")
        }
    }


    fun createAccount(email: String, password: String, confirmPassword: String) =
        viewModelScope.launch {
            if (password != confirmPassword) {
                _registerState.value = RegisterState.PasswordsMismatch
                return@launch
            }

            _registerState.value = RegisterState.Loading
            try {
                val result = userRepository.registerUser(
                    email = email,
                    password = password
                )
                when(result){
                    is RegisterResult.Failure -> _registerState.value = RegisterState.Fail(message = result.message)
                    RegisterResult.NonValidEmail -> _registerState.value = RegisterState.InvalidEmail
                    is RegisterResult.ServerError -> _registerState.value = RegisterState.Fail(message = "Server error")
                    is RegisterResult.Success -> _registerState.value = RegisterState.Success
                    RegisterResult.UserAlreadyExists -> _registerState.value = RegisterState.UserAlreadyExists
                }
            } catch (e: Exception) {
                _registerState.value = RegisterState.Fail("Unknown error")
            }
        }
}