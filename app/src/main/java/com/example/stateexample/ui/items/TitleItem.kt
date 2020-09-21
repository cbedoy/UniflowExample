package com.example.stateexample.ui.items

import com.example.stateexample.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_title.*

class TitleItem (val title: String) : Item(){
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.titleView.text = title
    }

    override fun getLayout(): Int {
        return R.layout.item_title
    }

}