package com.example.kaspi_3.sharedPreferences

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.kaspi_3.model.Favorites
import com.example.kaspi_3.model.LeftMessages
import com.example.kaspi_3.model.Messages
import com.example.kaspi_3.model.RightMessage
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class SharedPrefencesHelper(context:Context?)
{
    companion object {

        const val PREF_KEY = "PREF_KEY"
        const val FAV_KEY = "FAV_KEY"
        const val MSG_KEY = "MESSAGE_KEY"
        val MSG_TYPE: Type = object : TypeToken<MutableList<Pair<RightMessage,LeftMessages>>>() {}.type
        val FAV_TYPE:Type = object :TypeToken<MutableList<Favorites>>(){}.type
    }
    private lateinit var pref:SharedPreferences
    private val mGson: Gson = Gson()

    init {
        if (context != null) {
            pref = context.getSharedPreferences(PREF_KEY,Context.MODE_PRIVATE)
        }
    }
    fun addMessage(messages:Pair<RightMessage,LeftMessages>){
        var msgList:MutableList<Pair<RightMessage,LeftMessages>> = getMessage()
        Log.d("listtt",msgList.toString())
        msgList.add(messages)
        Log.d("add",messages.toString())
        pref.edit().putString(MSG_KEY,mGson.toJson(msgList, MSG_TYPE)).apply()
    }
    fun getMessage():MutableList<Pair<RightMessage,LeftMessages>>{
        return mGson.fromJson(pref.getString(MSG_KEY,""), MSG_TYPE)?:ArrayList<Pair<RightMessage,LeftMessages>>()

    }
    fun addFavorite(fav:Favorites){
        val favList = getFavorite()
        favList.add(fav)
        pref.edit().putString(FAV_KEY,mGson.toJson(favList, FAV_TYPE)).apply()
    }
    fun getFavorite():MutableList<Favorites>{
        return mGson.fromJson(pref.getString(FAV_KEY,""), FAV_TYPE)?:ArrayList<Favorites>()
    }

        }


