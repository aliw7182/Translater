package com.example.kaspi_3.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kaspi_3.model.Favorites
import com.example.kaspi_3.R
import com.example.kaspi_3.sharedPreferences.SharedPrefencesHelper
import kotlinx.android.synthetic.main.fr_fovorite.*

class FragmentFavorite:Fragment(R.layout.fr_fovorite) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPrefencesHelper = SharedPrefencesHelper(activity)
        val favAdapter = FavoriteAdapter()
        val favManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        RecyclerFav.apply {
            adapter = favAdapter
            layoutManager = favManager
        }
        val favList = sharedPrefencesHelper.getFavorite()
        Toast.makeText(activity,favList.toString(), Toast.LENGTH_LONG).show()

        favAdapter.setItems(favList)
    }
}