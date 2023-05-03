package com.example.mylibrary.ui.lists.vertical.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mylibrary.R
import com.example.mylibrary.ui.lists.model.ListItemModel

class VerticalListAdapter(private val items: List<ListItemModel>) :
    RecyclerView.Adapter<VerticalListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView= view.findViewById(R.id.item_title)
        val description: TextView= view.findViewById(R.id.item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.simple_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = items[position].header
        holder.description.text = items[position].subheader
    }

    override fun getItemCount(): Int {
        return items.size
    }
}