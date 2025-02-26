package com.example.recipebook.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipebook.R
import com.example.recipebook.Recipe
import com.example.recipebook.screens.modules.DishCard

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun HomeScreen(
    dishList: List<Recipe> = listOf(Recipe(), Recipe(), Recipe(), Recipe(), Recipe(), Recipe())
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.recipes),
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.accent),
                modifier = Modifier
                    .padding(40.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.what_do_you_want_to_cook),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 6.dp)
                )
                Text(
                    text = stringResource(R.string.enter_dish_name),
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 12.dp)
                )
            }
            SearchBar(
                query = "",
                onQueryChange = {},
                onSearch = {},
                active = true,
                onActiveChange = {},
                colors = SearchBarDefaults.colors(containerColor = Color.Transparent),
                trailingIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Search, contentDescription = "")
                    }
                },
                placeholder = { Text(stringResource(R.string.search))},
                modifier = Modifier.fillMaxWidth()
            ) {
                Spacer(Modifier.height(6.dp))
                LazyColumn{
                    items(dishList) { dishRecipe ->
                        DishCard(dishRecipe)
                    }
                }
            }

        }
    }
}