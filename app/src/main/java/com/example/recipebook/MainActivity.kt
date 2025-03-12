package com.example.recipebook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Scaffold
import com.example.recipebook.screens.HomeScreen
import com.example.recipebook.screens.modules.BottomBar
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
                        BottomBar()
                    }
                ) { paddingValues ->
                    paddingValues
                    HomeScreen(viewModel = viewModel)
                }
            }
        }
    }
}