package com.example.mylibrary.ui.lists.horizontal

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mylibrary.R
import com.example.mylibrary.ui.lists.horizontal.adapter.HorizontalListAdapter
import com.example.mylibrary.ui.lists.model.ListItemModel

@SuppressLint("CustomViewStyleable")
class HorizontalList @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private val headerTextView: TextView
    private var backgroundColor: Int? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.horizontal_list_layout, this, true)

        headerTextView = findViewById(R.id.horizontal_list_header)
        headerTextView.typeface = Typeface.create("roboto",Typeface.BOLD)
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.Item)
        val header = typedArray.getString(R.styleable.Item_header)
        headerTextView.text = header ?: context.resources.getString(R.string.header_header_default)

        backgroundColor = ContextCompat.getColor(context, R.color.header_background_light)
        setBackgroundColor(R.drawable.simple_header_background_light)

        val radius = resources.getDimension(R.dimen.simple_item_radius)
        val elevation = resources.getDimension(R.dimen.simple_item_elevation)

        val backgroundDrawable = GradientDrawable()
        backgroundDrawable.shape = GradientDrawable.RECTANGLE
        backgroundDrawable.cornerRadius = radius
        backgroundDrawable.setColor(backgroundColor!!)

        this.elevation = elevation

        this.background = backgroundDrawable

        typedArray.recycle()

        setRecyclerViewItems()

    }

    private fun setRecyclerViewItems(){
        val items = listOf(ListItemModel(
            "Title 1", "Subheader1"), ListItemModel(
            "Title2", "Subheader2"), ListItemModel(
            "Title3", "Subheader3"))
        setAdapter(items)
    }

    private fun setAdapter(items: List<ListItemModel>){
        val adapter = HorizontalListAdapter(items)
        val recyclerView: RecyclerView = findViewById(R.id.horizontal_list_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL
            ,false)
        recyclerView.adapter = adapter
    }
}
