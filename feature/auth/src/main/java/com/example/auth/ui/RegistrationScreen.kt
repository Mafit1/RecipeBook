package com.example.auth.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.auth.viewmodel.AuthViewModel
import com.example.auth.viewmodel.RegisterState
import com.example.core.R

@Composable
fun RegistrationScreen(
    paddingValues: PaddingValues,
    context: Context,
    onSuccess: () -> Unit,
    viewModel: AuthViewModel
) {
    val email = remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf(false) }

    val password = remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf(false) }

    val confirmPassword = remember { mutableStateOf("") }
    var confirmPasswordError by remember { mutableStateOf(false) }

    val authState = viewModel.registerState.collectAsState()

    when(authState.value){
        RegisterState.Idle -> {
            emailError = false
            passwordError = false
            confirmPasswordError = false
        }
        RegisterState.InvalidEmail -> {
            emailError = true

            Toast.makeText(
                context, "Email указан неверно", Toast.LENGTH_LONG
            ).show()
        }
        RegisterState.Loading -> {
            emailError = false
            passwordError = false
            confirmPasswordError = false
        }
        RegisterState.PasswordsMismatch -> {
            passwordError = true
            confirmPasswordError = true
        }
        RegisterState.Success -> { onSuccess.invoke() }
        RegisterState.UserAlreadyExists -> {
            emailError = true

            Toast.makeText(
                context, "Пользователь с таким email уже существует", Toast.LENGTH_LONG
            ).show()
        }
        is RegisterState.Fail -> {
            Toast.makeText(
                context, (authState.value as RegisterState.Fail).message, Toast.LENGTH_LONG
            ).show()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize().padding(paddingValues),
        contentAlignment = Alignment.Center
    ) {
        if (authState.value is RegisterState.Loading)
            CircularProgressIndicator()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f)
                .padding(55.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = stringResource(R.string.hello),
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.accent)
            )
            Text(
                text = stringResource(R.string.registration),
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold
            )
            Column(
            ) {
                OutlinedTextField(
                    value = email.value,
                    onValueChange = {email.value = it},
                    isError = emailError,
                    placeholder = { Text(stringResource(R.string.loginPlaceHolder)) },
                    modifier = Modifier
                        .padding(bottom = 12.dp)
                )
                OutlinedTextField(
                    value = password.value,
                    onValueChange = { password.value = it},
                    isError = passwordError,
                    placeholder = { Text(stringResource(R.string.passwordPlaceHolder)) },
                    modifier = Modifier
                        .padding(bottom = 12.dp)
                )
                OutlinedTextField(
                    value = confirmPassword.value,
                    onValueChange = { confirmPassword.value = it},
                    isError = confirmPasswordError,
                    placeholder = { Text(stringResource(R.string.repeat_password_placeHolder)) }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        viewModel.createAccount(
                            email = email.value,
                            password = password.value,
                            confirmPassword = confirmPassword.value
                        )
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.accent))
                ) {
                    Text(stringResource(R.string.register))
                }
            }
        }
    }
}