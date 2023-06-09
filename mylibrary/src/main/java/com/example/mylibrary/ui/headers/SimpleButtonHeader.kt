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
import com.example.mylibrary.ui.buttons.CustomButton

@SuppressLint("CustomViewStyleable")
class SimpleButtonHeader @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val headerTextView: TextView
    private val subheaderTextView: TextView
    private var backgroundColor: Int? = null
    private var button: CustomButton

    init {
        LayoutInflater.from(context).inflate(R.layout.simple_button_header_layout, this, true)

        headerTextView = findViewById(R.id.vertical_list_header)
        subheaderTextView = findViewById(R.id.item_description)
        button = findViewById(R.id.customButton)
        headerTextView.typeface = Typeface.create("roboto",Typeface.BOLD)
        subheaderTextView.typeface = Typeface.create("roboto",Typeface.NORMAL)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.Item)

        val header = typedArray.getString(R.styleable.Item_header)
        val subheader = typedArray.getString(R.styleable.Item_subheader)
        val isDarkStyle = typedArray.getBoolean(R.styleable.Item_isDarkStyle, false)
        val buttonText = typedArray.getString(R.styleable.Item_buttonText)

        headerTextView.text = header ?: context.resources.getString(R.string.header_header_default)
        subheaderTextView.text = subheader ?: context.resources.
        getString(R.string.header_subheader_default)
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
    }
}
