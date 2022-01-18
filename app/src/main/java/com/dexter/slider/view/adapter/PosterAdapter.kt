package com.dexter.slider.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dexter.slider.R
import com.dexter.slider.model.remote.Data
import kotlinx.android.synthetic.main.item_layout.view.*

class PosterAdapter(val Poster_list : List<Data>) : RecyclerView.Adapter<PosterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent , false)
        return PosterViewHolder(view)
    }

    override fun onBindViewHolder(holder: PosterViewHolder, position: Int) {
        holder.setData(Poster_list[position])
    }

    override fun getItemCount(): Int {
        return Poster_list.size
    }

}
class PosterViewHolder(val itemView :View): RecyclerView.ViewHolder(itemView){

    fun setData(data: Data){
        itemView.curr_number.setText(data.id)
    }


}