package com.example.stateexample.data.dto

data class Ingredients(
    val malt : List<Ingredient> = emptyList(),
    val hops: List<Ingredient> = emptyList()
)