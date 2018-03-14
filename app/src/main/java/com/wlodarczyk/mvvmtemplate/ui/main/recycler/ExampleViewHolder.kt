package com.wlodarczyk.mvvmtemplate.ui.main.recycler

import android.support.v7.widget.RecyclerView
import android.view.View
import com.wlodarczyk.mvvmtemplate.model.ExampleModel
import kotlinx.android.synthetic.main.item_example.view.*

class ExampleViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView) {

    fun bind(model: ExampleModel, listener: OnItemClickListener?) {
        itemView.nameLabel.text = model.name
        itemView.repositoryOwner.text = model.surname
        itemView.setOnClickListener({
            listener?.onItemClick(layoutPosition)
        })
    }
}