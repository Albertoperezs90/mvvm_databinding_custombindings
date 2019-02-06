package com.tutorial.aperezsi.mvvm_beers.viewmodel

import android.view.View
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import com.tutorial.aperezsi.mvvm_beers.BeersApp
import com.tutorial.aperezsi.mvvm_beers.R
import com.tutorial.aperezsi.mvvm_beers.adapter.BeerAdapter
import com.tutorial.aperezsi.mvvm_beers.model.BeerResponse
import com.tutorial.aperezsi.mvvm_beers.viewmodel.base.BaseViewModel

class BeerViewModel : BaseViewModel() {

    var showEmpty: ObservableInt = ObservableInt(View.GONE)
        private set

    var emptyBeers: ObservableField<String> = ObservableField(BeersApp.INSTANCE?.baseContext?.getString(R.string.empty_beers) ?: "")
        private set

    var adapter: BeerAdapter = BeerAdapter(this)
        private set

    var beers: MutableLiveData<List<BeerResponse>> = MutableLiveData()

    override fun init() {

    }

    fun setAdapter(beers: List<BeerResponse>){
        this.beers.value = beers
        adapter.setBeerList(this.beers.value!!)
        adapter.notifyDataSetChanged()
    }


    fun getBeer(position: Int) : BeerResponse? {
        return beers.value?.get(position)
    }
}