package com.example.recipebook.screens.modules

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.recipebook.R

@Preview(showBackground = true)
@Composable
fun BottomBar() {
    BottomAppBar {
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = { Icon(Icons.Default.Done, contentDescription = "")}
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = { Icon(Icons.Default.Done, contentDescription = "")}
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = { Icon(Icons.Default.Done, contentDescription = "")}
        )
    }
}