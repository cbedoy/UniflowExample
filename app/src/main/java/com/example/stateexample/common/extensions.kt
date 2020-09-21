package com.example.stateexample.common

import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.TextView


fun View.visible(){
   visibility = View.VISIBLE
}

fun View.visibleIfTrueElseGone(condition: Boolean){
    visibility = if (condition) View.VISIBLE else View.GONE
}

fun View.gone(){
    visibility = View.GONE
}

fun View.open(url: String){
    with(context){
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }
}

fun TextView.reloadText(newText: String){
    text = newText
    if (newText.isEmpty()){
        gone()
    }
}