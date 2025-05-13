package com.example.domain.model.recipe

data class Recipe(
    val dishName: String = "Dish name Dish name Dish name Dish name Dish name Dish name Dish name",
    val description: String = "Description",
    val recipeInstruction: String = "recipe instruction",
    val categories: List<DishCategory> = listOf(DishCategory.Breakfast, DishCategory.Dinner, DishCategory.Lunch),
    val image: Int? = null,
    val timeToCookSec: Int = 1800,
    val kcal: Int = 100,
    val ingredients: List<String> = listOf("Tomato", "Bread", "Onion"),
    val favorite: Boolean = false
)

