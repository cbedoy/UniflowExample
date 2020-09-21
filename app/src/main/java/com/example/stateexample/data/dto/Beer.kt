package com.example.stateexample.data.dto

data class Beer(
    val name: String = "",
    val description: String = "",
    val brewers_tips: String = "",
    val food_pairing: List<String> = emptyList(),
    val ingredients: Ingredients,
    val image_url: String = ""
)