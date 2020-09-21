package com.example.stateexample

import io.uniflow.androidx.flow.AndroidDataFlow
import java.lang.Exception

class BeerDataFlow (
    private val repository: BeerRepository
) : AndroidDataFlow() {

    init {
        action {
            BeerViewState.Init
        }
    }

    fun getRandomBeer() = action {
        try {
            val randomBeer = repository.getRandomBeer().first()
            setState {
                BeerViewState.GivenBeer(randomBeer)
            }
        }catch (e: Exception){
            BeerViewState.Failed(
                error = e
            )
        }
    }
}