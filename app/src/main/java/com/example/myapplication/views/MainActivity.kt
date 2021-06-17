package com.example.myapplication.views

import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.myapplication.R


class MainActivity : AppCompatActivity() {

// variable that we shall initialize at a later point in code
    lateinit var ip:EditText
    lateinit var port:EditText
    lateinit var buttonConnect:Button
    //lateinit var joystick: Joystick
    lateinit var rudder:SeekBar
    lateinit var throttle:SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //joystick.setOnClickListener()
        //val joystick = Joystick(this)
        //setContentView(R.layout.joystick)
        //val joystick = findViewById<Joystick>(R.id.allJoystick);
        //val canvas = Canvas()
        //joystick.draw(canvas);
        ip = findViewById(R.id.ipText);
        port = findViewById(R.id.portText);
        buttonConnect = findViewById(R.id.ConnectButton);
        rudder = findViewById(R.id.rudder);
        throttle = findViewById(R.id.throttle);

        buttonConnect.setOnClickListener {
            port.text.toString(); // todo send to vm to start
            ip.text.toString(); // todo send to vm
        }


        rudder.setOnClickListener(){        //rudder. todo update vm


        }
        throttle.setOnClickListener(){ //throttle. todo update vm

        }
       // joystick.onTouchEvent() //todo get the new param

        //joystick.onchange=(a,e) {//todo send the param to vm
            //vm.setAilron(a)
            //vm.setElevator(e)
        //}

    }





}