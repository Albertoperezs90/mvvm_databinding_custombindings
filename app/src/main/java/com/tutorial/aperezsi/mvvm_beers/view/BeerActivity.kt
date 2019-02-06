package com.tutorial.aperezsi.mvvm_beers.view

import android.os.Bundle
import android.view.View
import com.tutorial.aperezsi.mvvm_beers.R
import com.tutorial.aperezsi.mvvm_beers.databinding.ActivityBeerBinding
import com.tutorial.aperezsi.mvvm_beers.model.BeerResponse
import com.tutorial.aperezsi.mvvm_beers.view.base.BaseActivity
import com.tutorial.aperezsi.mvvm_beers.viewmodel.BeerViewModel

class BeerActivity : BaseActivity<ActivityBeerBinding, BeerViewModel>() {

    override fun getLayoutResource(): Int = R.layout.activity_beer
    override fun getViewModel(): Class<BeerViewModel> = BeerViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val beers= intent.getSerializableExtra("beers") as ArrayList<BeerResponse>?
        beers?.let {
            if (it.size == 0){
                model.showEmpty.set(View.VISIBLE)
            }else {
                model.setAdapter(it)
            }
        } ?: model.showEmpty.set(View.VISIBLE)

    }
}