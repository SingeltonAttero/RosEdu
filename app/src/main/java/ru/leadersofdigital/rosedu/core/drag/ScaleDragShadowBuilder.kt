package ru.leadersofdigital.rosedu.core.drag

import android.content.ClipData
import android.content.ClipDescription
import android.graphics.Canvas
import android.graphics.Point
import android.os.Build
import android.view.View

/**

 * @author YWeber */

class ScaleDragShadowBuilder(view: View, val height: Int, val width: Int) : View.DragShadowBuilder(view) {
    private var mScaleFactor: Point? = null

    override fun onProvideShadowMetrics(size: Point, touch: Point) {
        val scaleWidth = width
        val scaleHeight = height
        size.set(scaleWidth, scaleHeight)
        mScaleFactor = size
        touch.set(scaleWidth / 2, scaleHeight / 2)
    }


    override fun onDrawShadow(canvas: Canvas) {
        canvas.scale(
            (mScaleFactor?.x ?: width) / view.width.toFloat(),
            (mScaleFactor?.y ?: height) / view.height.toFloat()
        )
        view.draw(canvas)
    }

    companion object {
        fun createDate(id: Int): ClipData {
            val clipItem = ClipData.Item(id.toString())
            val type = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            return ClipData("Test", type, clipItem)
        }


    }
}

fun View.dragView(
    dragDate: ClipData,
    dragImg: View.DragShadowBuilder
) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        startDragAndDrop(dragDate, dragImg, null, 0)
    } else {
        startDrag(dragDate, dragImg, null, 0)
    }
}