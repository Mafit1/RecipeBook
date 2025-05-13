package com.example.core.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipebook.R
import com.example.recipebook.Recipe

@Preview
@Composable
fun FavItem(
    recipe: Recipe = Recipe(),
    modifier: Modifier = Modifier
        .padding(8.dp)
        .width(180.dp)
        .height(180.dp),
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp,
        ),
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = colorResource(R.color.gray))
    ) {
        Box(
            modifier = Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp),
                contentScale = ContentScale.Crop,
                contentDescription = ""
            )
            IconButton(
                onClick = {},
                modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.TopEnd)
                    .background(shape = RoundedCornerShape(8.dp), color = Color.White)
                    .size(30.dp)
            ) {
                Icon(painter = painterResource(R.drawable.baseline_favorite_24), "", tint = colorResource(R.color.accent))
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = recipe.dishName,
                modifier = Modifier,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.fire_svg),
                    contentDescription = "",
                    modifier = Modifier.size(18.dp),
                    colorResource(R.color.blackHalfTransparent)
                )
                Text(" " + recipe.kcal.toString() + " Kcal • ", fontSize = 12.sp, color = colorResource(R.color.blackHalfTransparent))
                Icon(
                    painter = painterResource(R.drawable.baseline_access_time_24),
                    contentDescription = "",
                    modifier = Modifier.size(18.dp),
                    tint = colorResource(R.color.blackHalfTransparent)
                )
                Text(" " + recipe.timeToCookSec / 60 + " min", fontSize = 12.sp, color = colorResource(R.color.blackHalfTransparent))
            }
        }

    }
}