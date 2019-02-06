package com.tutorial.aperezsi.mvvm_beers.networking

import com.tutorial.aperezsi.mvvm_beers.model.BeerResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PunkAPI {

    @GET("beers")
    fun getBeers() : Call<List<BeerResponse>>


    @GET("beers/{id}")
    fun getBeer(@Path("id") id: Int) : Call<BeerResponse>


    @GET("beers/random")
    fun getRandomBeer() : Call<BeerResponse>
}