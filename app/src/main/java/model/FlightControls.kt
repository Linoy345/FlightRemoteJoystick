package model

/*
    Handle and store plane controls value.
*/
class FlightControls {
    private var rudder : Float = 0f
    private var throttle : Float = 0f
    private var joystick : Pair<Float,Float> = Pair(0f,0f)

    fun getRudder() : Float{
        return this.rudder
    }
    fun getThrottle() : Float{
        return this.throttle
    }
    fun getJoystick() : Pair<Float,Float>{
        return this.joystick
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