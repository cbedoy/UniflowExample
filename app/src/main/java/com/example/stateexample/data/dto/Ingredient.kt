package com.example.stateexample.data.dto

data class Ingredient (
    val name: String = "",
    val amount: Amount = Amount(),
    val add: String = "",
    val attribute: String = ""
)