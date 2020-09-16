//package com.example.kaspi_3.ui
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.kaspi_3.R
//import com.example.kaspi_3.model.Searchs
//
//class SearchAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//    private val data = mutableListOf<Searchs>()
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        return SearchViewHolder(inflater, parent)
//    }
//
//    override fun getItemCount(): Int = data.size
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        (holder as SearchViewHolder).bind(data[position],data[position])
//
//
//
//
//    }
//
//    fun setItems(list: List<Searchs>) {
//        data.clear()
//        data.addAll(list)
//        notifyDataSetChanged()
//    }
//
//    private class SearchViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
//        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_search, parent, false)) {
//
//
//        fun bind(){
//
//
//        }
//    }
//} {
//}