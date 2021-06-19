package com.example.myapplication.views
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
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
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.ipUser =  binding.ipText.text.toString()
        binding.portUser =  binding.portText.text.toString().toInt()
        var widthRudder:Float = (rudder.width.toFloat()
                - rudder.paddingLeft.toFloat()
                - rudder.paddingRight.toFloat())
        binding.rudder.setOnClickListener{
           binding.rudderUser = binding.rudder.paddingLeft.toFloat() + widthRudder * rudder.progress.toFloat() / rudder.max.toFloat();
        }
        var widthThrottle:Float = (throttle.width.toFloat()
                - throttle.paddingLeft.toFloat()
                - throttle.paddingRight.toFloat())
        binding.throttle.setOnClickListener{
            binding.throttleUser = binding.throttle.paddingLeft.toFloat() + widthThrottle * throttle.progress.toFloat() / throttle.max.toFloat();
        }

        /*
        joystick = findViewById(R.id.allJoystick);
        ip = findViewById(R.id.ipText);
        port = findViewById(R.id.portText);
        buttonDisconnect = findViewById(R.id.disconnectButton);
        rudder = findViewById(R.id.rudder);
        throttle = findViewById(R.id.throttle);



        buttonDisconnect.setOnClickListener {
            //vm.VM_Disconnect()
        }

        rudder.setOnClickListener {
           //vm.VM_Rudder = vm.VM_Rudder + rudder.progress
        }

        throttle.setOnClickListener(){
            //vm.VM_Throttle = vm.VM_Throttle + throttle.progress
        }
       // joystick.onTouchEvent() //todo get the new param

        //joystick.onchange=(a,e) {//todo send the param to vm
            //vm.VM_Aileron = a
            //vm.VM_Elevator = e
        //}
        */
    }
}