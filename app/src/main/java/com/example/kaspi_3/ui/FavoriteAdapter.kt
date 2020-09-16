package com.example.kaspi_3.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kaspi_3.model.Favorites
import com.example.kaspi_3.R
import kotlinx.android.synthetic.main.fav_items.view.*

class FavoriteAdapter
:RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val data = mutableListOf<Favorites>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FavoriteViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as FavoriteViewHolder).bind(data[position].getInputText(),data[position].getOutText())




    }

    fun setItems(list: List<Favorites>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    private class FavoriteViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.fav_items, parent, false)) {
        private val inputTextView = itemView.inputFav
        private val outTextView = itemView.outputFav

        fun bind(inputText: String,outText:String){
            inputTextView.text = inputText
            outTextView.text = outText

        }
    }
}
