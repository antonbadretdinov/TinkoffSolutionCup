package com.example.tinkoffsolutioncupfinal.ui

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import androidx.core.content.ContextCompat
import com.example.tinkoffsolutioncupfinal.R
import kotlin.math.max
import kotlin.math.min

class Header @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0,
    ): View(context, attributeSet, defStyleAttr){

    @SuppressLint("CustomViewStyleable")
    val typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.HeaderView)
    private val title = typedArray.getString(R.styleable.HeaderView_title)
    private val subheader = typedArray.getString(R.styleable.HeaderView_subheader)
    private val description = typedArray.getString(R.styleable.HeaderView_description)

    private lateinit var mainRectPaint: Paint
    private lateinit var headerPaint: Paint
    private lateinit var titlePaint: Paint
    private lateinit var descriptionPaint: Paint
    private var minSize = 0f
    private lateinit var headerRect: RectF
    private var headerRectRadius = 0f
    private var headerFontSize: Float = 0f
    private var titleFontSize: Float = 0f
    private var descriptionFontSize: Float = 0f
    private var textSize: Float = 0f


    @SuppressLint("ResourceAsColor")
    private fun initPaints(){

        mainRectPaint = Paint(ANTI_ALIAS_FLAG)
        mainRectPaint.color = Color.WHITE
        mainRectPaint.setShadowLayer(10.0f, 0.0f, 0.0f, Color.LTGRAY)

        headerPaint = Paint(ANTI_ALIAS_FLAG)
        headerPaint.textAlign = Paint.Align.LEFT
        headerPaint.color = ContextCompat.getColor(context, HEADER_COLOR)
        headerPaint.typeface = resources.getFont(R.font.roboto_bold)
        headerFontSize = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP, 1f,
            resources.displayMetrics
        )*textSize* HEADER_TEXT_COEFFICIENT
        headerPaint.textSize = headerFontSize

        titlePaint = Paint(ANTI_ALIAS_FLAG)
        titlePaint.textAlign = Paint.Align.LEFT
        titlePaint.color = ContextCompat.getColor(context, HEADER_COLOR)
        titlePaint.typeface = resources.getFont(R.font.roboto)
        titleFontSize = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP, 1f,
            resources.displayMetrics
        )*textSize* TITLE_TEXT_COEFFICIENT
        titlePaint.textSize = titleFontSize

        descriptionPaint = Paint(ANTI_ALIAS_FLAG)
        descriptionPaint.textAlign = Paint.Align.LEFT
        descriptionPaint.color = ContextCompat.getColor(context, DESCRIPTION_COLOR)
        descriptionPaint.typeface = resources.getFont(R.font.roboto)
        descriptionFontSize = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP, 1f,
            resources.displayMetrics
        )*textSize* DESCRIPTION_TEXT_COEFFICIENT
        descriptionPaint.textSize = descriptionFontSize
    }



    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val mWidth = (MeasureSpec.getSize(widthMeasureSpec) - paddingLeft - paddingRight).toFloat()
        val mHeight = (MeasureSpec.getSize(heightMeasureSpec) - paddingTop - paddingBottom).toFloat()
        minSize = min(mWidth,mHeight)
        textSize = minSize/2

        val minWidth = suggestedMinimumWidth + paddingLeft + paddingRight
        val minHeight = suggestedMinimumWidth + paddingTop + paddingBottom
        val desiredSizeInPixels = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, DESIRED_SIZE,resources.displayMetrics).toInt()
        val desiredWidth = max(minWidth,desiredSizeInPixels + paddingLeft + paddingRight)
        val desiredHeight = max(minHeight,desiredSizeInPixels + paddingTop + paddingBottom)
        setMeasuredDimension(
            resolveSize(desiredWidth, widthMeasureSpec),
            resolveSize(desiredHeight, heightMeasureSpec)
        )

        drawMainRect(mWidth, mHeight)
    }

    private fun drawMainRect(screenWidth: Float, screenHeight: Float){
        headerRect = RectF(10f,10f, screenWidth-10, screenHeight-10)
        headerRectRadius = screenWidth/16
    }

    override fun onDraw(canvas: Canvas?) {
        initPaints()
        drawMainRect(canvas)
        if(title!=null) {
            drawTitle(canvas)
        }else{
            drawHeader(canvas)
        }
    }

    private fun drawTitle(canvas: Canvas?) {
        if (title != null) {
            if(description!=null){
                canvas?.drawText(title,width*0.2f,height*0.45f,titlePaint)
                drawDescription(canvas)
            }else{
                canvas?.drawText(title,width*0.2f,height*0.6f,titlePaint)
            }
        }
    }

    private fun drawDescription(canvas: Canvas?) {
        if (description != null) {
            canvas?.drawText(description,width*0.2f,height*0.75f,descriptionPaint)
        }
    }

    private fun drawHeader(canvas: Canvas?) {
        if(subheader!=null) {
            canvas?.drawText("Header", width * 0.05f, height * 0.4f, headerPaint)
            drawSubheader(canvas)
        }else{
            canvas?.drawText("Header", width * 0.05f, height * 0.6f, headerPaint)
        }
    }

    private fun drawSubheader(canvas: Canvas?) {
        if (subheader != null) {
            canvas?.drawText(subheader,width*0.05f,height*0.75f,descriptionPaint)
        }
    }

    private fun drawMainRect(canvas: Canvas?) {
        canvas?.drawRoundRect(headerRect,headerRectRadius,headerRectRadius, mainRectPaint)
    }

    companion object{
        const val DESIRED_SIZE = 400f
        const val TITLE_TEXT_COEFFICIENT = 0.18f
        const val HEADER_TEXT_COEFFICIENT = 0.2f
        const val DESCRIPTION_TEXT_COEFFICIENT = 0.14f
        const val HEADER_COLOR = R.color.header
        const val DESCRIPTION_COLOR = R.color.description

    }
}