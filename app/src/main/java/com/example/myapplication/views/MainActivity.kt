package com.example.myapplication.views
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.viewModel.ControlsViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding     // variable that we shall initialize at a later point in code
    var ip:String=""
    var port:String=""
    lateinit var ipUser:EditText
    lateinit var portUser:EditText
    lateinit var connButton: Button
    lateinit var disconnButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        var v = ControlsViewModel()

        portUser = findViewById(R.id.portText)
        ipUser = findViewById(R.id.ipText)
        connButton = findViewById(R.id.ConnectButton)
        disconnButton = findViewById(R.id.disconnectButton)

        ipUser.setOnClickListener{
           ip = ipUser.text.toString()
        }
        portUser.setOnClickListener {
            port = portUser.text.toString()
        }
        connButton.setOnClickListener {
            var a = ip //for debug
            var b = port
            v.VM_Connect(ip, port)
        }
        disconnButton.setOnClickListener{
            v.VM_Disconnect()
        }

       // binding.viewModel = v

        var widthRudder:Float = (binding.rudder.width.toFloat()
                - binding.rudder.paddingLeft.toFloat()
                - binding.rudder.paddingRight.toFloat())
        binding.rudder.setOnClickListener{
           v.VM_Rudder = binding.rudder.paddingLeft.toFloat() + widthRudder * binding.rudder.progress.toFloat() / binding.rudder.max.toFloat();
        }
        /*var widthThrottle:Float = (throttle.width.toFloat()
                - throttle.paddingLeft.toFloat()
                - throttle.paddingRight.toFloat())
        binding.throttle.setOnClickListener{
            binding.throttleUser = binding.throttle.paddingLeft.toFloat() + widthThrottle * throttle.progress.toFloat() / throttle.max.toFloat();
        }*/

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