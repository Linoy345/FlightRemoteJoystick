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

    var aileron:Float = 400F
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
        //paint.color = Color.GRAY
        //canvas.drawCircle(400F, 400F, 120F, paint)
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
        setVal(x,y) //todo vm
    }



}