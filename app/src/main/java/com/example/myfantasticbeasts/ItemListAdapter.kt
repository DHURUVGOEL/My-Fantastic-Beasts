package com.example.myfantasticbeasts

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

import androidx.constraintlayout.widget.ConstraintLayout


import androidx.recyclerview.widget.RecyclerView



class ItemListAdapter(private val items: ArrayList<Animaldata>) : RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item,parent,false)
//        val viewHolder = ItemViewHolder(view)
//        view.setOnClickListener{
//            listener.OnItemClicked(items[viewHolder.absoluteAdapterPosition])
//        }
       return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
       return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = items[position]

        holder.titleView.text = currentItem.name

        val cont = holder.constraint.context
        holder.constraint.setOnClickListener{
            val intent = Intent(it.context ,DetailActivity::class.java)

            intent.putExtra("item",currentItem.name)

            it.context.startActivity(intent)


            Toast.makeText(cont,"Clicked item is $currentItem ", Toast.LENGTH_SHORT).show()
        }

    }

}
class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val titleView: TextView = itemView.findViewById(R.id.Title)
    val constraint: ConstraintLayout = itemView.findViewById(R.id.constraint)
}
//interface ItemsItemClicked {
//    fun OnItemClicked(item:String)
//}

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