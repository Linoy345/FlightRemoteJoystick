package com.example.myapplication.model

class FlightModel()  {
    private var simulator: Client= Client()
    private var controlsInfo: FlightControls = FlightControls()

    var aileron: Float
        get() {
            return this.controlsInfo.getAileron()
        }
        set(value) {
            this.controlsInfo.setAileron(value)
        }

    var elevator: Float
        get() {
            return this.controlsInfo.getElevator()
        }
        set(value) {
            this.controlsInfo.setElevator(value)
        }
    var rudder: Float
        get() {
            return this.controlsInfo.getRudder()
        }
        set(value) {
            this.controlsInfo.setRudder(value)
        }
    var throttle: Float
        get() {
            return this.controlsInfo.getThrottle()
        }
        set(value) {
            this.controlsInfo.setThrottle(value)
        }

    fun connect(ip: String, port: Int) {
        this.simulator.connect(ip, port)
    }

    fun disconnect() {
        this.simulator.disconnect()
    }

    fun setSimulator(part: String) {
        this.simulator.write(this.controlsInfo.constructSetMessage(part))
    }

}