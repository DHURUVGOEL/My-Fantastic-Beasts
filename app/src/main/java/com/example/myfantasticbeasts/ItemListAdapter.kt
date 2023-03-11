package com.example.myfantasticbeasts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView


import androidx.recyclerview.widget.RecyclerView

class ItemListAdapter(private val items: ArrayList<String>,private val listener:ItemsItemClicked) : RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item,parent,false)
        val viewHolder = ItemViewHolder(view)
        view.setOnClickListener{
            listener.OnItemClicked(items[viewHolder.absoluteAdapterPosition])
        }
       return viewHolder
    }

    override fun getItemCount(): Int {
       return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = items[position]
        holder.titleView.text = currentItem
    }

}
class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val titleView: TextView = itemView.findViewById(R.id.Title)
}
interface ItemsItemClicked {
    fun OnItemClicked(item:String)
}

//
//// DiffCallback class for ListAdapter
//private class MyDiffCallback : DiffUtil.ItemCallback<String>() {
//
//    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
//        return oldItem == newItem
//    }
//
//    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
//        return oldItem == newItem
//    }
//}