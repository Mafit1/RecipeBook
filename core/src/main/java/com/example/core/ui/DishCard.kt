package com.example.core.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core.R
import com.example.domain.model.recipe.Recipe

@Preview(showBackground = true)
@Composable
fun DishCard(
    recipe: Recipe = Recipe()
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp,
        ),
        colors = CardDefaults.elevatedCardColors(containerColor = colorResource(R.color.gray)),
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .shadow(
                elevation = 3.dp,
                shape = RoundedCornerShape(24.dp)
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(8.dp)
        ) {
            Image(
                painter = if (recipe.image == null) painterResource(R.drawable.fire_svg)
                    else painterResource(recipe.image!!),
                contentDescription = "",
                modifier = Modifier
                    .size(90.dp)
                    .clip(RoundedCornerShape(24.dp))
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(start = 18.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .height(75.dp)
                        .weight(1f)
                ) {
                    Text(
                        text = recipe.dishName,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.fire_svg),
                            contentDescription = "",
                            modifier = Modifier.size(20.dp),
                            tint = colorResource(R.color.blackHalfTransparent)
                        )
                        Text(" " + recipe.kcal.toString() + " Kcal • ", color = colorResource(R.color.blackHalfTransparent))
                        Icon(
                            painter = painterResource(R.drawable.baseline_access_time_24),
                            contentDescription = "",
                            modifier = Modifier.size(20.dp),
                            tint = colorResource(R.color.blackHalfTransparent)
                        )
                        Text(" " + recipe.timeToCookSec / 60 + " min", color = colorResource(R.color.blackHalfTransparent))
                    }
                }
                Icon(
                    painter = if (recipe.favorite) painterResource(R.drawable.baseline_favorite_24)
                    else painterResource(R.drawable.baseline_favorite_border_24),
                    contentDescription = "",
                    tint = colorResource(R.color.accent),
                    modifier = Modifier
                        .clickable {  }
                        .padding(end = 8.dp)
                )
            }
        }
    }
}

@SuppressLint("DefaultLocale")
fun formatDuration(milliSeconds: Long) : String {
    val minutes = (milliSeconds / 1000) / 60
    val seconds = (milliSeconds / 1000) % 60
    return String.format("%1d:%02d", minutes, seconds)
}