package com.example.stateexample.ui.state

import com.example.stateexample.data.dto.Beer
import io.uniflow.core.flow.data.UIState

sealed class BeerViewState : UIState(){
    object Init: BeerViewState()
    data class GivenBeer(val beer: Beer) : BeerViewState()
    data class Failed(val error : Exception) : BeerViewState()
}