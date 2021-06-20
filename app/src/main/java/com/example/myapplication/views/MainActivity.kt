package com.example.myapplication.views
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.viewModel.ControlsViewModel

class MainActivity : AppCompatActivity() {
    var vm = ControlsViewModel()

    private lateinit var binding: ActivityMainBinding     // variable that we shall initialize at a later point in code

    lateinit var ipUser: EditText
    lateinit var portUser: EditText
    lateinit var connButton: Button
    lateinit var disconnButton: Button
    lateinit var joystick: Joystick
    lateinit var rudderSeekBar: SeekBar
    lateinit var throttleSeekBar: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        portUser = findViewById(R.id.portText)
        ipUser = findViewById(R.id.ipText)
        connButton = findViewById(R.id.ConnectButton)
        disconnButton = findViewById(R.id.disconnectButton)
        joystick = findViewById(R.id.joystickView)
        rudderSeekBar = findViewById(R.id.rudder)
        throttleSeekBar = findViewById(R.id.throttle)

        connection(ipUser, portUser, connButton)
        disconnection(disconnButton)
        moveRudder(rudderSeekBar)
        moveThrottle(throttleSeekBar)

        var aileron:Float = joystick.getcenterX()
        var elevator:Float = joystick.getcenterY()
        //check this
        joystick.service.onChange(aileron, elevator) -> {
            vm.VM_Aileron = aileron
            vm.VM_Elevator = elevator
        }



    }

    private fun connection(ipUser: EditText, portUser: EditText, connButton: Button) {
        var ip: String = ""
        var port: String = ""
        ipUser.setOnClickListener {
            ip = ipUser.text.toString()
        }
        portUser.setOnClickListener {
            port = portUser.text.toString()
        }
        connButton.setOnClickListener {
            vm.VM_Connect(ip, port)
        }
    }

    private fun disconnection(disconnButton: Button) {
        disconnButton.setOnClickListener {
            vm.VM_Disconnect()
        }
    }

    private fun moveRudder(rudderSeekBar: SeekBar) {
        val widthRudder: Float = (rudderSeekBar.width.toFloat()
                - rudderSeekBar.paddingLeft.toFloat()
                - rudderSeekBar.paddingRight.toFloat())
        rudderSeekBar.setOnClickListener {
            vm.VM_Rudder =
                rudderSeekBar.paddingLeft.toFloat() + widthRudder * rudderSeekBar.progress.toFloat() / rudderSeekBar.max.toFloat();
        }
    }

    private fun moveThrottle(throttleSeekBar: SeekBar) {
        val widthThrottle: Float = (throttleSeekBar.width.toFloat()
                - throttleSeekBar.paddingLeft.toFloat()
                - throttleSeekBar.paddingRight.toFloat())
        throttleSeekBar.setOnClickListener {
            vm.VM_Throttle =
                throttleSeekBar.paddingLeft.toFloat() + widthThrottle * throttleSeekBar.progress.toFloat() / throttleSeekBar.max.toFloat();
        }
    }
}