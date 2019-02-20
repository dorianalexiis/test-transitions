package com.android.testtranstisitions.ui.adapters

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.android.testtranstisitions.R
import com.android.testtranstisitions.ui.modules.button.ButtonActivity
import com.android.testtranstisitions.ui.modules.changetext.ChangeTextActivity
import com.android.testtranstisitions.ui.modules.grid.GridActivity
import com.android.testtranstisitions.ui.modules.image.ImageActivity
import com.android.testtranstisitions.ui.modules.pathcurved.PathCurvedActivity
import com.android.testtranstisitions.ui.modules.recolor.RecolorActivity
import com.android.testtranstisitions.ui.modules.transitionname.TransitionNameActivity
import com.android.testtranstisitions.utils.inflate
import com.transitionseverywhere.Recolor
import kotlinx.android.synthetic.main.item_list.view.*

class HomeAdapter(var list: MutableList<Int>) :
        RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(data: Int) {
            when(data){
                0 -> itemView.tvPosition.setText(R.string.home_button)
                1 -> itemView.tvPosition.setText(R.string.home_grid)
                2 -> itemView.tvPosition.setText(R.string.home_image)
                3 -> itemView.tvPosition.setText(R.string.home_pathcurved)
                4 -> itemView.tvPosition.setText(R.string.home_transitionname)
                5 -> itemView.tvPosition.setText(R.string.home_recolor)
                6 -> itemView.tvPosition.setText(R.string.home_changetext)
                else -> itemView.tvPosition.text = ""

            }

            itemView.setOnClickListener {
                when(data){
                    0 -> {
                        val intent = Intent(itemView.context, ButtonActivity::class.java)
                        itemView.context.startActivity(intent)
                    }
                    1 -> {
                        val intent = Intent(itemView.context, GridActivity::class.java)
                        itemView.context.startActivity(intent)
                    }
                    2 -> {
                        val intent = Intent(itemView.context, ImageActivity::class.java)
                        itemView.context.startActivity(intent)
                    }
                    3 -> {
                        val intent = Intent(itemView.context, PathCurvedActivity::class.java)
                        itemView.context.startActivity(intent)
                    }
                    4 -> {
                        val intent = Intent(itemView.context, TransitionNameActivity::class.java)
                        itemView.context.startActivity(intent)
                    }
                    5 -> {
                        val intent = Intent(itemView.context, RecolorActivity::class.java)
                        itemView.context.startActivity(intent)
                    }
                    6 -> {
                        val intent = Intent(itemView.context, ChangeTextActivity::class.java)
                        itemView.context.startActivity(intent)
                    }
                }
                //val intent = Intent(itemView.context, DetailActivity::class.java)
                //itemView.context.startActivity(intent, options.toBundle())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
            MyViewHolder(parent.inflate(R.layout.item_list))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        list.let {
            holder.bindView(position)
        }
    }

}
