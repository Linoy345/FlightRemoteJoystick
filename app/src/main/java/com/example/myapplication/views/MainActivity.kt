package com.example.myapplication.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.myapplication.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val joystick = Joystick(this)
       // setContentView(R.layout.joystick)

        val ip = findViewById<EditText>(R.id.ipText);

        val port = findViewById<EditText>(R.id.portText);

        val buttonConnect = findViewById<TextView>(R.id.ConnectButton);
        buttonConnect.setOnClickListener {
            port.text.toString(); // todo send to vm to start
            ip.text.toString(); // todo send to vm
        }

        val rudder = findViewById<SeekBar>(R.id.rudder);
        val throttle = findViewById<SeekBar>(R.id.throttle);

        //rudder. todo update from vm
        //throttle. todo update from vm

    }





}