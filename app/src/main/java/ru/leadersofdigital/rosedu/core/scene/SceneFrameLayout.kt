package ru.leadersofdigital.rosedu.core.scene

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.FrameLayout
import ru.leadersofdigital.rosedu.models.model.TypeConnection

class SceneFrameLayout @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    FrameLayout(context, attrs, defStyleAttr) {

    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val drawLinesConnections: MutableList<Pair<DrawLineField, Paint>> = mutableListOf()
    private var runConnectionDraw = false

    init {
        with(paint) {
            strokeWidth = 10F
            color = Color.BLUE
        }
    }

    fun addDrawConnections(lineFiled: DrawLineField, paint: Paint? = null) {
        runConnectionDraw = false
        if (paint != null) {
            this.paint = paint
        }
        if (drawLinesConnections.map { it.first.id }.contains(lineFiled.id)) {
            drawLinesConnections.removeAll { it.first.id == lineFiled.id }
            drawLinesConnections.add(lineFiled to this.paint)
        } else {
            drawLinesConnections.add(lineFiled to this.paint)
        }
    }

    fun deleteDrawConnection(id: Int) {
        runConnectionDraw = true
        drawLinesConnections.removeAll { it.first.id == id }
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (drawLinesConnections.isNotEmpty() && runConnectionDraw) {
            drawLinesConnections.forEach {
                if (it.first.isDraw) {
                    canvas.drawLine(
                        it.first.startX.toFloat(),
                        it.first.startY.toFloat(),
                        it.first.stopX.toFloat(),
                        it.first.stopY.toFloat(),
                        it.second
                    )
                    canvas.drawCircle(
                        it.first.startX.toFloat(),
                        it.first.startY.toFloat(), 17F, it.second
                    )
                    canvas.drawCircle(
                        it.first.stopX.toFloat(),
                        it.first.stopY.toFloat(), 17F, it.second
                    )
                }
            }

        }
    }

    fun allDrawConnection() {
        runConnectionDraw = true
        invalidate()
    }

    data class DrawLineField(
        val id: Int,
        val startX: Int,
        val startY: Int,
        val stopX: Int,
        val stopY: Int,
        val witch: Int = 0,
        val isDraw: Boolean = false,
        val typeConnection: TypeConnection = TypeConnection.TWISTED_PAIR
    )
}