package com.example.myapplication.views
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.HapticFeedbackConstants
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.viewModel.ControlsViewModel
import java.lang.Exception

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
        supportActionBar?.hide()
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

        joystick.service = Joystick.JoystickListener{ x, y ->
            vm.VM_Aileron = x
            vm.VM_Elevator = y
        }

        rudderSeekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                rudderSeekBar.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
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
                throttleSeekBar.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
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
            connButton.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
            try {
                vm.VM_Connect(ip, port)
                //vm.VM_Connect("172.18.53.46", "6400")
            } catch (e:Exception){
                //TODO: print can't connect error to user.
                alertMessage()
            }
        }
    }

    private fun disconnection(disconnButton: Button) {
        disconnButton.setOnClickListener {
            disconnButton.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
            vm.VM_Disconnect()
        }
    }

    private fun alertMessage() {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setMessage("Your ip or port are incorrect\n Please try again") // set message of alert dialog
            .setCancelable(false) // if the dialog is cancelable
            .setPositiveButton("Exit", DialogInterface.OnClickListener { // positive button text and action
                    dialog, id -> finish()
            })
            .setNegativeButton("Try again", DialogInterface.OnClickListener { // negative button text and action
                    dialog, id -> dialog.cancel()
            })
        val alert = dialogBuilder.create() // create dialog box
        alert.setTitle("Warning")// set title for alert dialog box
        alert.show() // show alert dialog
    }
}

