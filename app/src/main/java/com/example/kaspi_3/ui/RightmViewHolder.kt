package com.example.kaspi_3.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kaspi_3.R
import com.example.kaspi_3.model.Messages
import com.example.kaspi_3.model.RightMessage
import kotlinx.android.synthetic.main.item_left_message.view.*
import kotlinx.android.synthetic.main.item_right_message.view.*

class RightmViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_right_message, parent, false)) {
    private val messageTextView = itemView.textViewRight

    fun bind(item: Messages) {
        item as RightMessage
        messageTextView.text = item.message


    }
}