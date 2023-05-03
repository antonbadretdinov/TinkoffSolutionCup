package com.example.mylibrary.ui.lists.vertical

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
import com.example.mylibrary.ui.buttons.CustomButton
import com.example.mylibrary.ui.lists.vertical.adapter.VerticalListAdapter
import com.example.mylibrary.ui.lists.model.ListItemModel

@SuppressLint("CustomViewStyleable")
class VerticalButtonList @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private val headerTextView: TextView
    private var backgroundColor: Int? = null
    private var button: CustomButton

    init {
        LayoutInflater.from(context).inflate(R.layout.vertical_button_list_layout, this, true)
        button = findViewById(R.id.customButton)


        headerTextView = findViewById(R.id.vertical_list_header)
        headerTextView.typeface = Typeface.create("roboto",Typeface.BOLD)
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.Item)

        val header = typedArray.getString(R.styleable.Item_header)
        val isDarkStyle = typedArray.getBoolean(R.styleable.Item_isDarkStyle, false)
        val buttonText = typedArray.getString(R.styleable.Item_buttonText)

        headerTextView.text = header ?: context.resources.getString(R.string.header_header_default)
        button.text = buttonText.toString()

        if (isDarkStyle) {
            backgroundColor = ContextCompat.getColor(context, R.color.item_background_dark)
            setBackgroundColor(R.drawable.simple_header_background_dark)
        } else {
            backgroundColor = ContextCompat.getColor(context, R.color.item_background_light)
            setBackgroundColor(R.drawable.simple_header_background_light)
        }
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
            "Title2", "Subheader2"
        ))
        setAdapter(items)
    }

    private fun setAdapter(items: List<ListItemModel>){
        val adapter = VerticalListAdapter(items)
        val recyclerView: RecyclerView = findViewById(R.id.vertical_button_items_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }
}
