package com.example.stateexample

import com.example.stateexample.data.Beer
import io.uniflow.core.flow.data.UIState

sealed class BeerViewState : UIState(){
    object Init: BeerViewState()
    data class GivenBeer(val beer: Beer) : BeerViewState()
    data class Failed(val error : Exception) : BeerViewState()
}