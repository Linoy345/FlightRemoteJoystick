package com.example.myapplication.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

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

    //todo set the joystick state according to aileron+elevator

    var aileron:Float = 500.0F
    var elevator:Float = 400F
    var radius:Float = 300F

    private fun setVal(newAil:Float, newElev:Float) {
        this.aileron = newAil
        this.elevator = newElev
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        var paint = Paint()
        paint.color = Color.BLACK
        canvas.drawCircle(aileron, elevator, radius, paint)

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        val eventAction = event.action
        val x = event.x //todo send as rudder to vm
        val y = event.y //todo send as throttle to vm
        setVal(x,y)
        return true;
    }

}