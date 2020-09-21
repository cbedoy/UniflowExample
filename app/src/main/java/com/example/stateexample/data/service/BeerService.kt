package com.example.stateexample.data.service

import com.example.stateexample.data.dto.Beer
import retrofit2.http.GET

interface BeerService {
    @GET("beers/random")
    suspend fun getRandomBeer() : List<Beer>
}