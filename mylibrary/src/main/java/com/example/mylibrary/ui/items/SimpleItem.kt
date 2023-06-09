package com.example.mylibrary.ui.items

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.mylibrary.R

@SuppressLint("CustomViewStyleable")
class SimpleItem @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val titleTextView: TextView
    private val descriptionTextView: TextView
    private var backgroundColor: Int? = null
    var isDarkStyle: Boolean = false

    init {
        LayoutInflater.from(context).inflate(R.layout.simple_item_layout, this, true)

        titleTextView = findViewById(R.id.item_title)
        descriptionTextView = findViewById(R.id.item_description)
        titleTextView.typeface = Typeface.create("roboto",Typeface.NORMAL)
        descriptionTextView.typeface = Typeface.create("roboto",Typeface.NORMAL)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.Item)

        val title = typedArray.getString(R.styleable.Item_title)
        val description = typedArray.getString(R.styleable.Item_description)
        isDarkStyle = typedArray.getBoolean(R.styleable.Item_isDarkStyle, false)

        titleTextView.text = title ?: context.resources.getString(R.string.item_title_default)
        descriptionTextView.text = description ?: context.resources.
                                                getString(R.string.item_description_default)

        if (isDarkStyle) {
            backgroundColor = ContextCompat.getColor(context, R.color.item_background_dark)
            setBackgroundColor(R.drawable.simple_item_background_dark)
        } else {
            backgroundColor = ContextCompat.getColor(context, R.color.item_background_light)
            setBackgroundColor(R.drawable.simple_item_background_light)
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
    }
}