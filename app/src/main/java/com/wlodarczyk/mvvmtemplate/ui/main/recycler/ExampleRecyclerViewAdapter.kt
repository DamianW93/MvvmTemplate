package com.wlodarczyk.mvvmtemplate.ui.main.recycler

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.wlodarczyk.mvvmtemplate.R
import com.wlodarczyk.mvvmtemplate.model.ExampleModel

class ExampleRecyclerViewAdapter(private var items: ArrayList<ExampleModel>,
                                 private val listener: OnItemClickListener)
    : RecyclerView.Adapter<ExampleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.item_example, parent, false)
        return ExampleViewHolder(itemView)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) =
            holder.bind(items[position], listener)
}