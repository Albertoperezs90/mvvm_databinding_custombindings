package com.tutorial.aperezsi.mvvm_beers.viewmodel

import android.view.View
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import com.tutorial.aperezsi.mvvm_beers.model.BeerResponse
import com.tutorial.aperezsi.mvvm_beers.model.BeersWarehouse
import com.tutorial.aperezsi.mvvm_beers.viewmodel.base.BaseViewModel

class SplashViewModel : BaseViewModel() {


    var beers: MutableLiveData<List<BeerResponse>> = MutableLiveData()
        get() = BeersWarehouse.beers
        private set


    var loading: ObservableInt = ObservableInt(View.VISIBLE)
        private set


    override fun init() {
        BeersWarehouse.fetchBeers()
    }

}