package com.example.mylibrary.ui.headers

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
class SimpleHeader @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val headerTextView: TextView
    private val subheaderTextView: TextView
    private var backgroundColor: Int? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.simple_header_layout, this, true)

        headerTextView = findViewById(R.id.header_header)
        subheaderTextView = findViewById(R.id.header_subheader)
        headerTextView.typeface = Typeface.create("roboto",Typeface.BOLD)
        subheaderTextView.typeface = Typeface.create("roboto",Typeface.NORMAL)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.SimpleItem)

        val header = typedArray.getString(R.styleable.SimpleItem_header)
        val subheader = typedArray.getString(R.styleable.SimpleItem_subheader)
        val isDarkStyle = typedArray.getBoolean(R.styleable.SimpleItem_isDarkStyle, false)

        headerTextView.text = header ?: context.resources.getString(R.string.header_header_default)
        subheaderTextView.text = subheader ?: context.resources.
        getString(R.string.header_subheader_default)

        if (isDarkStyle) {
            backgroundColor = ContextCompat.getColor(context, R.color.header_background_dark)
            setBackgroundColor(R.drawable.simple_header_background_dark)
            headerTextView.setTextColor(
                context.getColor(R.color.header_header_color_dark))
            subheaderTextView.setTextColor(
                context.getColor(R.color.header_subheader_color_dark))
        } else {
            backgroundColor = ContextCompat.getColor(context, R.color.header_background_light)
            setBackgroundColor(R.drawable.simple_header_background_light)
            headerTextView.setTextColor(
                context.getColor(R.color.header_header_color))
            subheaderTextView.setTextColor(
                context.getColor(R.color.header_subheader_color))
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