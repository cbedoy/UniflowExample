package com.example.stateexample.ui.viewmodel

import com.example.stateexample.data.repository.BeerRepository
import com.example.stateexample.ui.state.BeerViewState
import io.uniflow.androidx.flow.AndroidDataFlow
import java.lang.Exception

class BeerViewModel (
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