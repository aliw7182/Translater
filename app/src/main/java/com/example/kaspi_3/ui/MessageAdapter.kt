package com.example.kaspi_3.ui

import android.os.Message
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kaspi_3.R
import com.example.kaspi_3.model.LeftMessages
import com.example.kaspi_3.model.Messages
import com.example.kaspi_3.model.RightMessage

class MessageAdapter(
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data = mutableListOf<Messages>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            R.layout.item_left_message -> LeftmViewHolder(inflater, parent)
            R.layout.item_right_message -> RightmViewHolder(inflater, parent)
            else -> LeftmViewHolder(inflater, parent)
        }
    }

    override fun getItemViewType(position: Int): Int =
        when(data[position]){
                is RightMessage-> R.layout.item_right_message
                is LeftMessages -> R.layout.item_left_message
            else -> R.layout.item_left_message
        }

    override fun getItemCount(): Int {
        Log.d("size",data.size.toString())
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LeftmViewHolder -> {holder.bind(data[position])}
            is RightmViewHolder -> {holder.bind(data[position])}
        }
    }

    fun setItems(list: MutableList<Messages>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()

    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }
    fun getItem(position: Int):Messages = data[position]


}