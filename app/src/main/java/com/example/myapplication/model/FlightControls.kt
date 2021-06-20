package com.example.myapplication.model

val DEFAULT_RUDDER = 0f
val DEFAULT_THROTTLE = 0f
val DEFAULT_AILERON = 0f
val DEFAULT_ELEVATOR = 0f



/*
    Handle and store plane controls value.
*/
class FlightControls {
    private var rudder : Float = DEFAULT_RUDDER
    private var throttle : Float = DEFAULT_THROTTLE
    private var joystick : Pair<Float,Float> = Pair(DEFAULT_AILERON, DEFAULT_ELEVATOR)

    fun getRudder() : Float{
        return this.rudder
    }
    fun getThrottle() : Float{
        return this.throttle
    }
    fun getAileron() : Float{
        return this.joystick.first
    }
    fun getElevator() : Float{
        return this.joystick.second
    }
    fun setRudder(newValue: Float){
        this.rudder = newValue
    }
    fun setThrottle(newValue: Float){
        this.throttle = newValue
    }
    fun setAileron(newValue: Float){
        this.joystick = this.joystick.copy(first = newValue)
    }
    fun setElevator(newValue: Float){
        this.joystick = this.joystick.copy(second = newValue)
    }
    fun resetControls(){
        setRudder(DEFAULT_RUDDER)
        setThrottle(DEFAULT_THROTTLE)
        setAileron(DEFAULT_AILERON)
        setElevator(DEFAULT_ELEVATOR)
    }

/*
    Convert given plane part to a set Message for flight gear with current part value
*/
    fun constructSetMessage(part :String) : String{
        if(part == "rudder"){
            return "set/controls/flight/rudder " + this.rudder +"\r\n"
        }
        if(part == "throttle"){
            return "set/controls/engines/current-engine/throttle " + this.throttle +"\r\n"
        }
        if(part == "aileron"){
            return "set/controls/flight/aileron " + this.joystick.first +"\r\n"
        }
        if(part == "elevator"){
            return "set/controls/flight/elevator " + this.joystick.second +"\r\n"
        }
        return ""
    }
}