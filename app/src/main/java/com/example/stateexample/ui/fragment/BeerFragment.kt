package com.example.stateexample.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import coil.api.load
import com.example.stateexample.*
import com.example.stateexample.common.*
import com.example.stateexample.data.dto.Beer
import com.example.stateexample.ui.items.IngredientItem
import com.example.stateexample.ui.state.BeerViewState
import com.example.stateexample.ui.viewmodel.BeerViewModel
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import io.uniflow.androidx.flow.onStates
import kotlinx.android.synthetic.main.fragment_beer_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class BeerFragment : Fragment() {
    private val viewModel : BeerViewModel by viewModel()

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

        hopsCard.gone()
        maltCard.gone()
        beerCard.gone()
        tipsTitleView.gone()
        ingredientsView.gone()

        errorTitleView.gone()
        errorMessageView.gone()


        onStates(viewModel){ state ->
            when(state){
                is BeerViewState.Init -> {
                    progressBar.visible()

                    hopsCard.gone()
                    maltCard.gone()

                    beerCard.gone()
                }
                is BeerViewState.Failed -> {
                    hopsCard.gone()
                    maltCard.gone()
                    beerCard.gone()

                    progressBar.gone()

                    errorTitleView.visible()
                    errorMessageView.visible()
                }
                is BeerViewState.GivenBeer -> {
                    errorTitleView.gone()
                    errorMessageView.gone()

                    reloadBeerDetail(state.beer)
                }
            }
        }
        malt_recycler_view.layoutManager = LinearLayoutManager(context)
        hop_recycler_view.layoutManager = LinearLayoutManager(context)

        malt_recycler_view.adapter = maltAdapter
        hop_recycler_view.adapter = hopsAdapter

        creditView.setOnClickListener {
            it.open("https://github.com/cbedoy")
        }

        viewModel.getRandomBeer()
    }

    private fun reloadBeerDetail(beer: Beer) {
        titleView.reloadText(beer.name)
        descriptionView.reloadText(beer.description)

        tipsView.reloadText(beer.brewers_tips)
        previewView.load(beer.image_url){
            crossfade(true)
        }

        hopsAdapter.addAll(beer.ingredients.hops.map {
            IngredientItem(it)
        })

        maltAdapter.addAll(beer.ingredients.malt.map {
            IngredientItem(it)
        })

        hopsCard.visibleIfTrueElseGone(condition = hopsAdapter.groupCount > 0)
        maltCard.visibleIfTrueElseGone(condition = maltAdapter.groupCount > 0)
        beerCard.visible()

        tipsTitleView.visible()
        ingredientsView.visible()

        progressBar.gone()
    }
}