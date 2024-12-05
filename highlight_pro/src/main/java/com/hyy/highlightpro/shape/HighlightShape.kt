package com.hyy.highlightpro.shape

import android.graphics.*
import com.hyy.highlightpro.util.dp


/**
 *Create by hyy on 2021/2/7
 */
open class HighlightShape(val blurRadius: Float = 0.0f) {

    private var paint: Paint

    //clip path
    internal val path by lazy {
        Path()
    }

    init {
        paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            isDither = true
            color = Color.YELLOW
        }
        paint.style = Paint.Style.STROKE
        paint.strokeWidth= 5f.dp
        //paint blur style
//        if (blurRadius > 0) {
//            paint.maskFilter = BlurMaskFilter(blurRadius, BlurMaskFilter.Blur.SOLID)
//        }
    }

    protected var rect: RectF? = null

    /**
    *  init rect  child should override initRect and init path
    * */
    open fun initRect(rectF: RectF) {
        this.rect = rectF
    }

    /**
     *  draw our path
     */
    fun drawPath(canvas: Canvas) {
        rect?.run {
            if (isEmpty.not()) {
                canvas.drawPath(path, paint)
            }
        }
    }

    fun setPaint(paint: Paint) {
        this.paint = paint
    }
}