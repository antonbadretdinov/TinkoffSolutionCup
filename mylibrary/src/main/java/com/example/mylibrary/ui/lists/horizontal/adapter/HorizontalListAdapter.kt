package com.example.mylibrary.ui.lists.horizontal.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mylibrary.R
import com.example.mylibrary.ui.lists.model.ListItemModel

class HorizontalListAdapter(private val items: List<ListItemModel>) :
    RecyclerView.Adapter<HorizontalListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView= view.findViewById(R.id.item_title_horizontal)
        val description: TextView= view.findViewById(R.id.item_description_horizontal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.simple_item_horizontal_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = items[position].title
        holder.description.text = items[position].description
    }

    override fun getItemCount(): Int {
        return items.size
    }
}