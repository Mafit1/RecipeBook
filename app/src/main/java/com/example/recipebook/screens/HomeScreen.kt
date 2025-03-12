package com.example.recipebook.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipebook.MainViewModel
import com.example.recipebook.R
import com.example.recipebook.Recipe

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    dishList: List<Recipe> = listOf(Recipe(), Recipe(), Recipe(), Recipe(), Recipe(), Recipe()),
    viewModel: MainViewModel
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
            val query = rememberSaveable { mutableStateOf("") }
            val isActive = rememberSaveable { mutableStateOf(false) }
            SearchBar(
                modifier = Modifier
                    .fillMaxWidth(),
                query = query.value,
                onQueryChange = { query.value = it },
                placeholder = {
                    Text(
                        text = "Поиск",
                        //color = colorResource(R.color.text_second)
                    )
                },
                leadingIcon = {
                    IconButton(onClick = {
                        viewModel.search(query = query.value)
                    }) {
                        Icon(Icons.Default.Search, "", //tint = colorResource(R.color.text_second)
                        )
                    }
                },
                trailingIcon = {
                    if (isActive.value && query.value != "") {
                        IconButton(onClick = { query.value = "" }) {
                            Icon(
                                Icons.Default.Clear,
                                "",
                            )
                        }
                    }
                },
                onSearch = { },
                active = isActive.value,
                onActiveChange = {
                    isActive.value = it
                },
                colors = SearchBarDefaults.colors(
                    containerColor = Color.Transparent,
                    dividerColor = colorResource(R.color.white),
//                inputFieldColors = TextFieldDefaults.colors(
//                    focusedTextColor = colorResource(R.color.text),
//                    unfocusedTextColor = colorResource(R.color.text)
//                )
                )
            ) {

                if (viewModel.errorState.collectAsState().value) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                "Проблемы с соединением",
                                //color = colorResource(R.color.text),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                            TextButton(onClick = {
                                viewModel.search(query.value)
                            }) {
                                Text(
                                    "Обновить",
                                    //color = colorResource(R.color.accent),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                )
                            }
                        }

                    }
                } else if (viewModel.emptyState.collectAsState().value) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                "Ничего не найдено",
                                //color = colorResource(R.color.text),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                        }

                    }
                } else {
                    val list = viewModel.products.collectAsState().value
                    LazyColumn {
                        items(list) { product ->
                            Text("${product.title} ${product.category}")
                        }
                    }
                }
            }
            /*
            SearchBar(
                query = query.value,
                onQueryChange = {
                    query.value = it
                },
                onSearch = {
                    viewmodel.search(query = query.value)
                },
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
                val list = viewmodel.product.collectAsState().value
                Spacer(Modifier.height(6.dp))
                LazyColumn{
                    items(list) { product ->
                        Text("${product.title} ${product.brand}")
                        //DishCard(dishRecipe)
                    }
                }
            }
*/
        }
    }
}