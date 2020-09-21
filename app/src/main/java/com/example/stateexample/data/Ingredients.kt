package com.example.stateexample.data

data class Ingredients(
    val malt : List<Ingredient> = emptyList(),
    val hops: List<Ingredient> = emptyList()
)