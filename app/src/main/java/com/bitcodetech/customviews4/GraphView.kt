package com.bitcodetech.customviews4

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.ImageView

class GraphView(
    context : Context,
    attributeSet: AttributeSet?
) : androidx.appcompat.widget.AppCompatImageView(context, attributeSet) {

    var values : ArrayList<Int>? = null
    set(value) {
        field = value
        invalidate()
    }

    private val paint : Paint

    init {
        paint = Paint()
        paint.setColor(Color.RED)
    }

    constructor(context: Context) : this(context, null)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if(values == null) {
            return
        }


        canvas!!.drawText("BitCode",0F, 50F, paint)

        val barWidth = width.toFloat() / values!!.size
        val percToHeightPixels = height.toFloat() / 100;

        for((index, v) in values!!.withIndex()) {
            canvas!!.drawRect(
                index * barWidth,
                height - v * percToHeightPixels,
                index * barWidth + barWidth - 10,
                height.toFloat(),
                paint
            )
        }
    }

}












