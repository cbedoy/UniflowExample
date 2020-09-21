package com.example.stateexample

import com.example.stateexample.data.Beer
import retrofit2.http.GET

interface BeerService {
    @GET("beers/random")
    suspend fun getRandomBeer() : List<Beer>
}