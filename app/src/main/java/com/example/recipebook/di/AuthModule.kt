package com.example.recipebook.di

import com.example.auth.viewmodel.AuthViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val authModule = module {
    viewModel<AuthViewModel> {
        AuthViewModel(
            userRepository = get()
        )
    }
}