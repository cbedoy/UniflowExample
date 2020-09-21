package com.example.stateexample.items

import com.example.stateexample.R
import com.example.stateexample.data.Ingredient
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_description.*

class IngredientItem(private val ingredient: Ingredient) : Item(){
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.titleView.text = ingredient.name
        viewHolder.valueView.text = ingredient.amount.let {
            "${it.value} ${it.unit}"
        }
    }

    override fun getLayout(): Int {
        return R.layout.item_description
    }

}