package com.example.myapplication.views
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import kotlin.math.*

class Joystick : View {

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
    }

    private fun init(context: Context) {
        //do stuff that was in your original constructor...
    }

    private var centerX = 0
    private var centerY = 0
    private var bigRadius = 0
    private var littleRadius = 0

   private fun setup() {
       this.centerX = (width / 2)
       this.centerY = (height / 2)
       this.bigRadius = min(width, height) / 3
       this.littleRadius = min(width, height) / 5

   }


    fun drawJoystick(x:Float, y:Float, canvas: Canvas) {
        var paint = Paint()
        paint.color = Color.BLACK
        canvas.drawCircle(400F, 400F, 300F, paint)
        paint.color = Color.GRAY
        canvas.drawCircle(x, y, 100F, paint)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //drawJoystick(aileron,elevator,canvas)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if(event == null) {
            return true;
        }
        when (event?.action) {
            MotionEvent.ACTION_MOVE -> touchMove(event.x, event.y)
        }
        return true;
    }

    private fun touchMove(x:Float, y:Float) {
        //setVal(x,y) //todo vm
    }



}