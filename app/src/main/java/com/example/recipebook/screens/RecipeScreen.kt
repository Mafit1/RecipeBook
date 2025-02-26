package com.example.recipebook.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipebook.R
import com.example.recipebook.Recipe

@Preview(showSystemUi = true)
@Composable
fun RecipeScreen(recipe: Recipe = Recipe(), modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .padding(top = 40.dp, bottom = 16.dp)
                .clip(RoundedCornerShape(20.dp))
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                modifier = Modifier
                    .size(200.dp),
                contentDescription = ""
            )
        }
        Text(
            text = recipe.dishName,
            fontSize = 26.sp,
            color = colorResource(R.color.accent),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            recipe.description,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            "Ingridients",
            fontSize = 26.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        recipe.ingredients.forEach {
            Text(
                "- $it",
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 16.dp, bottom = 4.dp)
            )
        }


    }
}
/*
@Composable
fun LoadImageWithPlaceholder(
    imageUrl: String?, // URL изображения
    placeholderResId: Int, // Ресурс заглушки (например, R.drawable.placeholder)
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
) {
    // Создаем painter для загрузки изображения
    val painter = rememberAsyncImagePainter(
        model = imageUrl,
        placeholder = painterResource(id = placeholderResId) // Устанавливаем заглушку
    )

    // Отображаем изображение
    AsyncImage(
        model = imageUrl,
        contentDescription = null, // Описание для accessibility
        modifier = modifier,
        contentScale = contentScale,
        placeholder = painterResource(id = placeholderResId), // Заглушка
        error = painterResource(id = placeholderResId) // Заглушка в случае ошибки
    )
}
*/