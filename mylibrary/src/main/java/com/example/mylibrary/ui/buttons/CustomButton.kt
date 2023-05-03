package com.example.mylibrary.ui.buttons

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import com.example.mylibrary.R

@SuppressLint("CustomViewStyleable")
class CustomButton(context: Context, attrs: AttributeSet?) :
    AppCompatButton(context, attrs) {

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.Item,
            androidx.appcompat.R.attr.buttonStyle, R.style.CustomButtonStyle)
        typedArray.recycle()
    }
}