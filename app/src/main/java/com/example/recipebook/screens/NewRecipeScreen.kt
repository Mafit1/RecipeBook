package com.example.recipebook.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipebook.R

@Preview(showBackground = true)
@Composable
fun NewRecipeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f)
                .padding(55.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = stringResource(R.string.new_recipe),
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.accent)
            )
            Column(
            ) {
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    placeholder = { Text(stringResource(R.string.name)) },
                    modifier = Modifier
                        .padding(bottom = 12.dp)
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    placeholder = { Text(stringResource(R.string.description)) },
                    modifier = Modifier
                        .padding(bottom = 12.dp)
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    placeholder = { Text(stringResource(R.string.ingredients)) },
                    modifier = Modifier
                        .padding(bottom = 12.dp)
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    placeholder = { Text(stringResource(R.string.categories)) },
                    modifier = Modifier
                        .padding(bottom = 12.dp)
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    placeholder = { Text(stringResource(R.string.recipe_instruction)) },
                    modifier = Modifier
                        .padding(bottom = 12.dp)
                )
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.accent))
                ) {
                    Text(stringResource(R.string.add))
                }
            }
        }
    }
}