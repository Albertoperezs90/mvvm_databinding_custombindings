package com.tutorial.aperezsi.mvvm_beers.model

import android.util.Log
import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import com.tutorial.aperezsi.mvvm_beers.networking.PunkApiBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object BeersWarehouse : BaseObservable() {

    var beers: MutableLiveData<List<BeerResponse>> = MutableLiveData()
        private set


    fun fetchBeers() {
        PunkApiBuilder.api.getBeers().enqueue(object : Callback<List<BeerResponse>> {
            override fun onFailure(call: Call<List<BeerResponse>>, t: Throwable) {
                Log.e("Test", t.message, t)
            }

            override fun onResponse(call: Call<List<BeerResponse>>, response: Response<List<BeerResponse>>) {
                beers.value = response.body()
            }

        })
    }


}