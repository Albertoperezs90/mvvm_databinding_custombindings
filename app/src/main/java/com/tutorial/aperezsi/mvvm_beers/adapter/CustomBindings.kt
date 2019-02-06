package com.tutorial.aperezsi.mvvm_beers.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


@BindingAdapter("setAdapter")
fun bindRecyclerViewAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>){
    recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
    (recyclerView.layoutManager as LinearLayoutManager).orientation = RecyclerView.VERTICAL
    recyclerView.adapter = adapter
    val itemDecorator = DividerItemDecoration(recyclerView.context, (recyclerView.layoutManager as LinearLayoutManager).orientation)
    recyclerView.addItemDecoration(itemDecorator)
    adapter.notifyDataSetChanged()
}


@BindingAdapter("imageUrl")
fun bindRecyclerViewAdapter(imageView: ImageView, imageUrl: String?){
    Glide.with(imageView).load(imageUrl?:"").into(imageView)
}
