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
    private var bigRadius:Float = 0F
    private var littleRadius:Float = 0F
    lateinit var canvas: Canvas

    fun interface JoystickListener {
        fun onChange(x: Float, y: Float)
    }

    public lateinit var service:JoystickListener

    private fun setup(width:Float, height:Float) {
        this.centerX = (width / 2)
        this.centerY = (height / 2)
        this.bigRadius = (min(width, height) / 2)
        this.littleRadius = (min(width, height) / 6)
    }

    constructor(context: Context) : super(context) {
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {

    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
    }

    private fun updateValues(x:Float, y:Float) {
        this.centerX = x
        this.centerY = y
    }

    private fun checkValidMove(x:Float, y:Float) {
        val distance =
            sqrt((x - centerX).toDouble().pow(2.0) + (y - centerY).toDouble().pow(2.0))
                .toFloat()
        if(distance < bigRadius) { //valid
            updateValues(x, y)
            drawJoystick(x, y)
            service.onChange(x,y)
        } else { //invalid - constrain the joystick to the big radius
            val ratio: Float = bigRadius / distance
            val constrainedX: Float = centerX + (x - centerX) * ratio
            val constrainedY: Float = centerY + (y - centerY) * ratio
            updateValues(constrainedX, constrainedY)
            drawJoystick(constrainedX, constrainedY)
            service.onChange(constrainedX,constrainedY)
        }
    }

    private fun drawJoystick(x:Float, y:Float) {
        var paint = Paint()
        paint.color = Color.BLACK
        canvas.drawCircle(x, y, bigRadius, paint)
        paint.color = Color.GRAY
        canvas.drawCircle(x, y, littleRadius, paint)

    }

    override fun onDraw(canvas: Canvas) {
        this.canvas = canvas
        super.onDraw(canvas)
        setup(width.toFloat(), height.toFloat())
        drawJoystick(centerX, centerY)
    }

    override fun setOnTouchListener(l: OnTouchListener?) {
        super.setOnTouchListener(l)

    }



    override fun onTouchEvent(event: MotionEvent): Boolean {
        if(event == null) {
            return true;
        }
        when (event?.action) {
            MotionEvent.ACTION_MOVE -> checkValidMove(event.x, event.y)
        }
        return true;
    }





}