package com.tutorial.aperezsi.mvvm_beers

import androidx.multidex.MultiDexApplication

class BeersApp : MultiDexApplication() {

    companion object {
        var INSTANCE: BeersApp? = null
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}