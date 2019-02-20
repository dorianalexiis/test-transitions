package com.android.testtranstisitions.ui.adapters

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.android.testtranstisitions.R
import com.android.testtranstisitions.ui.modules.button.ButtonActivity
import com.android.testtranstisitions.utils.inflate
import kotlinx.android.synthetic.main.item_list.view.*



class GridAdapter(var list: MutableList<Int>, val clicklistener : OnClick) :
        RecyclerView.Adapter<GridAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View, val clicklistener : OnClick) : RecyclerView.ViewHolder(itemView) {
        fun bindView(data: Int) {
            itemView.tvPosition.text = data.toString()

            itemView.setOnClickListener {
                clicklistener.onClick(it)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
            MyViewHolder(parent.inflate(R.layout.item_list), clicklistener)

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        list.let {
            holder.bindView(position)
        }
    }

    interface OnClick{
        fun onClick(view:View)
    }

}
