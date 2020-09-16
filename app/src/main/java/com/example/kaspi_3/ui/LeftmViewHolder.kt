package com.example.kaspi_3.ui

import android.annotation.SuppressLint
import android.util.Log
import android.view.*
import android.widget.PopupMenu
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kaspi_3.R
import com.example.kaspi_3.model.Favorites
import com.example.kaspi_3.model.LeftMessages
import com.example.kaspi_3.model.Messages
import com.example.kaspi_3.model.RightMessage
import com.example.kaspi_3.sharedPreferences.SharedPrefencesHelper
import kotlinx.android.synthetic.main.item_left_message.view.*

class LeftmViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_left_message, parent, false)),
    View.OnLongClickListener, PopupMenu.OnMenuItemClickListener {
    private val messageTextView = itemView.textViewLeft

    init {
        messageTextView.setOnLongClickListener(this)
    }

    fun bind(item: Messages) {
        item as LeftMessages
        messageTextView.text = item.message
    }

    override fun onLongClick(v: View?): Boolean {
        showMenu(v)
        return true
    }

    private fun showMenu(v: View?) {
        val PopupMenu = PopupMenu(v?.context, v);
        PopupMenu.inflate(R.menu.context_menu)
        PopupMenu.setOnMenuItemClickListener(this)
        try {
            val fiieldMPopup = PopupMenu::class.java.getDeclaredField("mPopup")
            fiieldMPopup.isAccessible = true
            val mPopup = fiieldMPopup.get(PopupMenu)
            mPopup.javaClass
                .getDeclaredMethod("setForceShowIcon",Boolean::class.java)
                .invoke(mPopup,true)
        }catch (e:Exception){
            Log.e("POPUP",e.toString())
        }
        finally {
            PopupMenu.show()
        }
        PopupMenu.show()
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.copy -> {
              return  true
            }
            R.id.share -> {
               return true
            }
            R.id.delete -> {
               return true
            }
            R.id.addFavorite -> {
              return addToFavorite()
            }
            else ->  return false
        }
    }
    private fun addToFavorite():Boolean{
        val sharedPrefencesHelper = SharedPrefencesHelper(this.messageTextView.context)
        val messageAdapter = MessageAdapter()
        val msglist:MutableList<Messages> = mutableListOf()
        sharedPrefencesHelper.getMessage().forEach {
           msglist.addAll(it.toList())
        }
        messageAdapter.setItems(msglist)
        val outString = this.messageTextView.text.toString()
        val secondMessage = messageAdapter.getItem(adapterPosition-1)
        if (secondMessage != null) {
            Toast.makeText(this.messageTextView.context,secondMessage.toString(), Toast.LENGTH_LONG).show()
        }
        if (secondMessage is RightMessage){
            val favorites = Favorites(secondMessage.message,outString)
            sharedPrefencesHelper.addFavorite(favorites)
        }

        return true
    }
}

