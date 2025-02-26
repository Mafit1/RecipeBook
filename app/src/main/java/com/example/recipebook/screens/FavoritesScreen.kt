package com.example.recipebook.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipebook.R
import com.example.recipebook.Recipe
import com.example.recipebook.screens.modules.FavItem

@Preview(showSystemUi = true)
@Composable
fun FavouritesScreen(list: List<Recipe> = List(20) { Recipe() }) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Favorites",
            fontSize = 26.sp,
            color = colorResource(R.color.accent),
            modifier = Modifier.padding(vertical = 16.dp)
        )

        val recipeGroups = list.chunked(2)

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(recipeGroups) { group ->
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    group.forEach { item ->
                        FavItem(item, modifier = Modifier.weight(0.5f).padding(8.dp))
                    }
                }
            }
        }
    }
}
