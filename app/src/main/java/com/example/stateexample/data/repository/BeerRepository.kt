package com.example.stateexample.data.repository

import com.example.stateexample.data.service.BeerService
import com.example.stateexample.data.dto.Beer

class BeerRepository (
    private val service: BeerService
){
    suspend fun getRandomBeer() : List<Beer> = service.getRandomBeer()
}