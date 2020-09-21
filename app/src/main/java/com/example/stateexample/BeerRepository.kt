package com.example.stateexample

import com.example.stateexample.data.Beer

class BeerRepository (
    private val service: BeerService
){
    suspend fun getRandomBeer() : List<Beer> = service.getRandomBeer()
}