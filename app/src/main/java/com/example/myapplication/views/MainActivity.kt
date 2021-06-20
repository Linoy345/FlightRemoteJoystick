package com.example.myapplication.views
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.viewModel.ControlsViewModel

class MainActivity : AppCompatActivity() {
    private var vm = ControlsViewModel()

    private lateinit var binding: ActivityMainBinding     // variable that we shall initialize at a later point in code

    private lateinit var ipUser: EditText
    private lateinit var portUser: EditText
    private lateinit var connButton: Button
    private lateinit var disconnButton: Button
    private lateinit var joystick: Joystick
    private lateinit var rudderSeekBar: SeekBar
    private lateinit var throttleSeekBar: SeekBar

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

       /* joystick.setOnTouchListener {v: View, m: MotionEvent ->
            joystick.move(m)
            true
        }*/




        joystick.service = Joystick.JoystickListener{ x, y ->
            vm.VM_Aileron = x
            vm.VM_Elevator = y
        }

        rudderSeekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                vm.VM_Rudder = progress.toFloat()/100F //to get range from -1 to 1
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        throttleSeekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                vm.VM_Throttle = progress.toFloat()/100F //to get range from 0 to 1
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }


    private fun connection(ipUser: EditText, portUser: EditText, connButton: Button) {
        var ip = ""
        var port = ""
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


}

