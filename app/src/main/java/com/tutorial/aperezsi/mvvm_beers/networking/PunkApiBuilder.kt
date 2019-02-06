package com.tutorial.aperezsi.mvvm_beers.networking

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.tutorial.aperezsi.mvvm_beers.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PunkApiBuilder {

    val api : PunkAPI by lazy {
        with(Retrofit.Builder()) {
            baseUrl(BuildConfig.URL_BASE)
            client(createClient())
            addConverterFactory(GsonConverterFactory.create(createDeserializer()))
            build()
        }.create(PunkAPI::class.java)
    }

    private fun createClient() : OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }


    private fun createDeserializer() : Gson {
        return GsonBuilder()
            .create()
    }
}