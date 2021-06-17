package com.example.myapplication.views

import android.content.Context
import android.graphics.Canvas
import android.os.Bundle
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class Joystick(context: Context?) : View(context) {

    //todo set the joystick state according to aileron+elevator


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return false;
    }

}