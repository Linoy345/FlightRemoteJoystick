package com.example.myapplication.views
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.myapplication.R
import com.example.myapplication.viewModel.ControlsViewModel


class MainActivity : AppCompatActivity() {
    var vm: ControlsViewModel = ControlsViewModel()
    // variable that we shall initialize at a later point in code
    lateinit var ip:EditText
    lateinit var port:EditText
    lateinit var buttonConnect:Button
    lateinit var buttonDisconnect:Button
    lateinit var joystick: Joystick
    lateinit var rudder:SeekBar
    lateinit var throttle:SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        joystick = findViewById(R.id.allJoystick);
        ip = findViewById(R.id.ipText);
        port = findViewById(R.id.portText);
        buttonConnect = findViewById(R.id.ConnectButton);
        buttonDisconnect = findViewById(R.id.disconnectButton);
        rudder = findViewById(R.id.rudder);
        throttle = findViewById(R.id.throttle);

        buttonConnect.setOnClickListener {
            vm.VM_Connect(ip.text.toString(), port.text.toString().toInt())
        }

        buttonDisconnect.setOnClickListener {
            vm.VM_Disconnect()
        }

        rudder.setOnClickListener {
            vm.VM_Rudder = vm.VM_Rudder + rudder.progress
        }

        throttle.setOnClickListener(){
            vm.VM_Throttle = vm.VM_Throttle + throttle.progress
        }
       // joystick.onTouchEvent() //todo get the new param

        //joystick.onchange=(a,e) {//todo send the param to vm
            //vm.VM_Aileron = a
            //vm.VM_Elevator = e
        //}

    }
}