package com.tutorial.aperezsi.mvvm_beers.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.tutorial.aperezsi.mvvm_beers.R
import com.tutorial.aperezsi.mvvm_beers.databinding.ActivitySplashBinding
import com.tutorial.aperezsi.mvvm_beers.extensions.toArrayList
import com.tutorial.aperezsi.mvvm_beers.model.BeerResponse
import com.tutorial.aperezsi.mvvm_beers.view.base.BaseActivity
import com.tutorial.aperezsi.mvvm_beers.viewmodel.SplashViewModel

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>(){


    override fun getLayoutResource(): Int = R.layout.activity_splash
    override fun getViewModel(): Class<SplashViewModel> = SplashViewModel::class.java


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model.init()
        setupBindings()
    }


    private fun setupBindings() {
        model.beers.observe(this, Observer {
            model.loading.set(View.GONE)
            goToMainScreen(it)
        })
    }

    private fun goToMainScreen(beers: List<BeerResponse>) {
        val intent = Intent(this, BeerActivity::class.java)
        intent.putExtra("beers", beers.toArrayList())
        startActivity(intent)
    }
}