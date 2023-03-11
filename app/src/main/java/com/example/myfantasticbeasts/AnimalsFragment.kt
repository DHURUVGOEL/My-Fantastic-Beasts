
package com.example.myfantasticbeasts


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnCreateContextMenuListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView



class AnimalsFragment : Fragment(), ItemsItemClicked {

    private lateinit var recyclerView: RecyclerView
     private lateinit var viewModel: AnimalViewModel

     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//         ViewModelProvider(this,
//             ViewModelProvider.AndroidViewModelFactory.getInstance(application:Application)).get(AnimalViewModel::class.java)
//             .also { viewModel = it }



//        { item ->
//            // Handle item click event here
//            val intent = Intent(activity, MainActivity::class.java)
//            intent.putExtra("item", item)
//            startActivity(intent)
//        }
//         Initialize RecyclerView and its adapter

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_animals, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context , 3) // Set grid layout with 2 columns

        val items = fetchData()
        val adapter = ItemListAdapter(items,this)
        recyclerView.adapter= adapter
        return view

    }
    // Sample data
    private fun fetchData(): ArrayList<String> {
        val list = ArrayList<String>()
        for(i in 0 until 100){
            list.add("Item $i")
        }
        return list
    }

    override fun OnItemClicked(item: String) {
        Toast.makeText(context,"Clicked item is $item ",Toast.LENGTH_SHORT).show()
    }

}

//        // Initialize RecyclerView and its adapter
//        recyclerView = view.findViewById(R.id.recyclerView)
//        adapter = MyAdapter { item ->
//            // Handle item click event here
//            val intent = Intent(activity, MainActivity::class.java)
//            intent.putExtra("item", item)
//            startActivity(intent)
//        }
//        recyclerView.adapter = adapter
//        recyclerView.layoutManager = GridLayoutManager(context, 2) // Set grid layout with 2 columns
//
//        // Set data to the adapter
//        adapter.submitList(getData())
//
//        return view
//    }
//
//    // Sample data
//    private fun getData(): List<String> {
//        return listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
//    }
//
//    // Adapter class for RecyclerView
//    private inner class MyAdapter(private val onItemClick: (String) -> Unit) :
//        RecyclerView.Adapter<MyViewHolder>(MyDiffCallback()) {
//
//        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//            val view = LayoutInflater.from(parent.context)
//                .inflate(R.layout.each_item, parent, false)
//            return MyViewHolder(view)
//        }
//
//        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//            val item = getItem(position)
//            holder.bind(item)
//
//            holder.itemView.setOnClickListener {
//                onItemClick(item)
//            }
//        }
//
//    }
//    // ViewHolder class for RecyclerView
//    private inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//        fun bind(item: String) {
//            itemView.findViewById<TextView>(R.id.Title).text = item
//        }
//    }
//    // DiffCallback class for ListAdapter
//    private class MyDiffCallback : DiffUtil.ItemCallback<String>() {
//
//        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
//            return oldItem == newItem
//        }
//
//        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
//            return oldItem == newItem
//        }
//    }