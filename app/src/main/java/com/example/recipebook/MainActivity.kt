package com.example.recipebook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.auth.ui.LoginScreen
import com.example.auth.ui.RegistrationScreen
import com.example.auth.viewmodel.AuthViewModel
import com.example.recipebook.screens.HomeScreen
import com.example.core.ui.BottomBar
import com.example.recipebook.ui.theme.RecipeBookTheme
import kotlinx.serialization.Serializable
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val authViewModel by viewModel<AuthViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            var botBarState by rememberSaveable { mutableStateOf(false) }

            RecipeBookTheme {
                Scaffold(
                    bottomBar = {
                        if (botBarState)
                            BottomBar()
                    }
                ) { paddingValues ->

                    NavHost(navController = navController, startDestination = ScreenLogin) {
                        composable<ScreenLogin> {
                            LoginScreen(
                                paddingValues = paddingValues,
                                context = this@MainActivity,
                                onSuccess = {
                                    navController.navigate(ScreenHome)
                                    botBarState = true
                                },
                                toRegistration = { navController.navigate(ScreenRegistration) },
                                viewModel = authViewModel
                            )
                        }
                        composable<ScreenRegistration> {
                            RegistrationScreen(
                                paddingValues = paddingValues,
                                context = this@MainActivity,
                                onSuccess = {
                                    navController.navigate(ScreenHome)
                                    botBarState = true
                                },
                                viewModel = authViewModel
                            )
                        }
                        composable<ScreenHome> {
                            HomeScreen()
                        }
                    }
                }
            }
        }
    }
}

@Serializable
object ScreenHome

@Serializable
object ScreenRegistration

@Serializable
object ScreenLogin