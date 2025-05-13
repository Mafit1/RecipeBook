package com.example.recipebook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import com.example.recipebook.screens.HomeScreen
import com.example.core.ui.BottomBar
import com.example.recipebook.ui.theme.RecipeBookTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContent {
            RecipeBookTheme {
                Scaffold(
                    bottomBar = {
                        com.example.core.ui.BottomBar()
                    }
                ) { paddingValues ->
                    paddingValues
                    HomeScreen(viewModel = viewModel)
                }
            }
        }
    }
}