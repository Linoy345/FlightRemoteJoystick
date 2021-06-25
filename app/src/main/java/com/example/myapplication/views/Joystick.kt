package com.example.myapplication.views
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.sqrt

class Joystick : View {
    private var centerX:Float = 0F
    private var centerY:Float = 0F
    private var changeX:Float = 0F
    private var changeY:Float = 0F
    private var bigRadius:Float = 0F
    private var littleRadius:Float = 0F

    fun interface JoystickListener {
       fun onChange(x: Float, y: Float) : Unit
    }

    var service:JoystickListener =JoystickListener { _, _ ->Unit}
    constructor(context: Context) : super(context) {
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
    }


    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
    }

    private fun setup(width:Float, height:Float) {
        this.centerX = (width / 2)
        this.centerY = (height / 2)
        if(this.changeX == 0F){
            this.changeX = (width / 2)
        }
        if(this.changeY == 0F){
            this.changeY = (height / 2)
        }
        this.bigRadius = (min(width, height)) / 3
        this.littleRadius = (min(width, height)) / 7
    }


    override fun onDraw(canvas: Canvas) {
        setup(width.toFloat(), height.toFloat())
        super.onDraw(canvas)
        val paint = Paint()
        paint.color = Color.BLACK
        canvas.drawCircle(centerX, centerY, bigRadius, paint)
        paint.color = Color.GRAY
        canvas.drawCircle(changeX, changeY, littleRadius, paint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if(event == null) {
            return true;
        }
        if(event.actionMasked == MotionEvent.ACTION_DOWN ||
            event.actionMasked == MotionEvent.ACTION_MOVE)  {
            val x = event.x
            val y = event.y
            val distance =
                sqrt((x - centerX).toDouble().pow(2.0) + (y - centerY).toDouble().pow(2.0))
                    .toFloat()
            if(distance < bigRadius) { //valid
                changeX = x
                changeY = y
            } else { //invalid - constrain the joystick to the big radius
                val ratio = bigRadius / distance
                val constrainedX = centerX + (x - centerX) * ratio
                val constrainedY = centerY + (y - centerY) * ratio
                changeX = constrainedX
                changeY = constrainedY
            }
            service.onChange(((changeX - centerX)/bigRadius) ,((changeY - centerY)/bigRadius)*-1)
        } else { //return the joystick to the middle
            changeX = centerX
            changeY = centerY
            service.onChange(0F ,0F)
        }
        invalidate()
        return true;
    }


}
