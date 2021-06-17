package com.example.myapplication.views

import android.content.Context
import android.graphics.Canvas
import android.view.MotionEvent
import android.view.View

class Joystick(context: Context?) : View(context) {
    //todo set the joystick state according to aileron+elevator


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        /*override fun onTouch(v: View?, event: MotionEvent?): Boolean {
            when (event?.action) {
                MotionEvent.ACTION_DOWN -> //Do Something
            }

            return v?.onTouchEvent(event) ?: true
        }*/
        val eventAction = event.action
        // you may need the x/y location
        val x = event.x.toDouble() //todo send as rudder to vm
        val y = event.y.toDouble() //todo send as throttle to vm

        return true;
    }

}