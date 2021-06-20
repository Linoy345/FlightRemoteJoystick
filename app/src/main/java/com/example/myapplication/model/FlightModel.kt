package com.example.myapplication.model

import java.util.concurrent.Executors

class FlightModel()  {
    private var simulator: Client= Client()
    private var controlsInfo: FlightControls = FlightControls()
    private var executor = Executors.newSingleThreadExecutor()

    var aileron: Float
         get() {
            return this.controlsInfo.getAileron()
        }
        set(value) {
            executor.execute { this.controlsInfo.setAileron(value) }
        }

    var elevator: Float
        get() {
            return this.controlsInfo.getElevator()
        }
        set(value) {
            executor.execute{this.controlsInfo.setElevator(value)}
        }
    var rudder: Float
        get() {
            return this.controlsInfo.getRudder()
        }
        set(value) {
            executor.execute {this.controlsInfo.setRudder(value)}
        }
    var throttle: Float
        get() {
            return this.controlsInfo.getThrottle()
        }
        set(value) {
            executor.execute {this.controlsInfo.setThrottle(value)}
        }

    fun connect(ip: String, port: Int) {
        executor.execute {this.simulator.connect(ip, port)}
    }

    fun disconnect() {
        executor.execute{ this.simulator.disconnect()}
    }

    fun setSimulator(part: String) {
        executor.execute{ this.simulator.write(this.controlsInfo.constructSetMessage(part))}
    }

    fun resetControls() {
        executor.execute{ this.controlsInfo.resetControls()}
    }
}