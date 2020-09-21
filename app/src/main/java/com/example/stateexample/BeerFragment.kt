package com.example.stateexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import coil.api.load
import com.example.stateexample.data.Beer
import com.example.stateexample.items.IngredientItem
import com.example.stateexample.items.TitleItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import io.uniflow.androidx.flow.onStates
import kotlinx.android.synthetic.main.fragment_beer_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class BeerFragment : Fragment() {
    private val dataFlow : BeerDataFlow by viewModel()

    private val hopsAdapter = GroupAdapter<GroupieViewHolder>()
    private val maltAdapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment_beer_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onStates(dataFlow){ state ->
            when(state){
                is BeerViewState.Init -> {
                    progressBar.visible()
                    malt_recycler_view.gone()
                    hop_recycler_view.gone()
                    beerCard.gone()
                }
                is BeerViewState.Failed -> {

                }
                is BeerViewState.GivenBeer -> {
                    reloadBeerDetail(state.beer)
                }
            }
        }
        malt_recycler_view.layoutManager = LinearLayoutManager(context)
        hop_recycler_view.layoutManager = LinearLayoutManager(context)

        malt_recycler_view.adapter = maltAdapter
        hop_recycler_view.adapter = hopsAdapter

        dataFlow.getRandomBeer()
    }

    private fun reloadBeerDetail(beer: Beer) {
        titleView.text = beer.title
        descriptionView.text = beer.description

        tipsView.text = beer.brewers_tips
        previewView.load(beer.image_url){
            crossfade(true)
        }


        hopsAdapter.addAll(beer.ingredients.hops.map {
            IngredientItem(it)
        })

        maltAdapter.addAll(beer.ingredients.malt.map {
            IngredientItem(it)
        })

        malt_recycler_view.visible()
        hop_recycler_view.visible()
        beerCard.visible()

        progressBar.gone()
    }
}