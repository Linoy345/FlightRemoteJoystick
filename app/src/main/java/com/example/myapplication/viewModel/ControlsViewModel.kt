package com.example.myapplication.viewModel
//import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.FlightModel

open class ControlsViewModel : ViewModel() {
    var model: FlightModel = FlightModel()

    var VM_Aileron: Float
        get() {
            return model.aileron
        }
        set(value) {
            model.aileron = value
            model.setSimulator("aileron")
        }

    var VM_Elevator: Float
        get() {
            return model.elevator
        }
        set(value) {
            model.elevator = value
            model.setSimulator("elevator")
        }
    var VM_Rudder: Float
        get() {
            return model.rudder
        }
        set(value) {
            model.rudder = value
            model.setSimulator("rudder")
        }
    var VM_Throttle: Float
        get() {
            return model.throttle
        }
        set(value) {
            model.throttle = value
            model.setSimulator("throttle")
        }

    fun VM_Connect(ip: String, port: Int){
        this.model.connect(ip, port)
    }

    fun VM_Disconnect(){
        this.model.disconnect()
    }
}