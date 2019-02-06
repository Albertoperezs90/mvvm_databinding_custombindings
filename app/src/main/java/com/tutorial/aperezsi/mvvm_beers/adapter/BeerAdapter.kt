package com.tutorial.aperezsi.mvvm_beers.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.tutorial.aperezsi.mvvm_beers.R
import com.tutorial.aperezsi.mvvm_beers.databinding.BeerRowBinding
import com.tutorial.aperezsi.mvvm_beers.model.BeerResponse
import com.tutorial.aperezsi.mvvm_beers.viewmodel.BeerViewModel

class BeerAdapter (val model: BeerViewModel): RecyclerView.Adapter<BeerAdapter.ViewHolder>(){

    private var beers: List<BeerResponse>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: BeerRowBinding = DataBindingUtil.inflate(inflater, viewType, parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = beers?.size ?: 0

    override fun onBindViewHolder(holder: BeerAdapter.ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    private fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.beer_row
    }

    fun setBeerList(beers: List<BeerResponse>) {
        this.beers = beers
    }


    inner class ViewHolder (val binding: BeerRowBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int){
            binding.setVariable(BR.model, model)
            binding.setVariable(BR.position, position)
            binding.executePendingBindings()
        }
    }

}