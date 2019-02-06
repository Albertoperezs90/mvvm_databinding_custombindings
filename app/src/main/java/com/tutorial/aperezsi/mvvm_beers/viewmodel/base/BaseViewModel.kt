package com.tutorial.aperezsi.mvvm_beers.viewmodel.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    /**
     * Startup method for viewModels classes
     */
    abstract fun init()
}