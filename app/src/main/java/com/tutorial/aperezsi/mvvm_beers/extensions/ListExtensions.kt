package com.tutorial.aperezsi.mvvm_beers.extensions

fun <T> List<T>.toArrayList() : ArrayList<T>{
    val array = ArrayList<T>()
    array.addAll(this)
    return array
}