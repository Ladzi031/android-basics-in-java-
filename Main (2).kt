import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

//unlike Java, kotlin classes are final by default, restricting them from 'EXTENDing' them without explicitly stating that with the "open" keyword
open class SmartDevice(val name: String, val category: String) {
    var deviceStatus = "online"
    protected set
    
    
    open val deviceType = "unknown"
    
    
    //similar to methods here...
   open fun turnOn() {
       deviceStatus = "on"
        // println("Smart device is turned on.")
    }
    open fun turnOff() {
        deviceStatus = "off"
       // println("Smart device is turned off.")
    }
}
// when creating the sub-class constructor and having to declare variables that have to initialise the super-class, you don't have to specify the immutablilty(var/val)
class SmartTvDevice(deviceName: String, deviceCategory: String) : SmartDevice(name = deviceName, category = deviceCategory) {
    
    override val deviceType = "Smart TV"
    
   private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)
   
   private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)
    
    fun increaseSpeakerVolume() {
        this.speakerVolume++
        println("Speaker volume increased to ${speakerVolume}")
    }
    fun nextChannel() {
        this.channelNumber++
        println("Channer number increased to ${channelNumber}")
    }
    override fun turnOn() {
        super.turnOn()
        println("${name} turned on. Speaker volume is set to ${speakerVolume} and channel number is set to ${channelNumber}")
    }
    override fun turnOff() {
        super.turnOff()
        println("${name} turned off")
    }
    
}
class SmartLightDevice(deviceName: String, deviceCategory: String) : SmartDevice(name = deviceName, category = deviceCategory) {
    
    override val deviceType = "Smart Light"
    
   private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)
   
    fun increaseBrightness() {
        this.brightnessLevel++
        println("Brightness increased to ${brightnessLevel}")
    }
    //override keyword has to be explicitly stated, to tell kotlin runtime to execute code enclosed in the subClass...
    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("${name} turned on. The brightness level is ${brightnessLevel}")
        
    }
    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off.")
    }
}
class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {
    var deviceTurnOnCount = 0
    private set
    
    
    fun turnOnTv() {
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }
    
    fun turnOffTv() {
        deviceTurnOnCount--
        smartTvDevice.turnOff()
    }
    
    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }
    
    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }
    
    fun turnOnLight() {
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }
    
    fun turnOffLight() {
        deviceTurnOnCount--
        smartLightDevice.turnOff()
    }
    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }
    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}
class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {
    var fieldData = initialValue
    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if(value in minValue..maxValue) {
            fieldData = value
        }
    }
}
fun main(){
    var smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment")
    smartDevice.turnOn()
    //output code : "Android TV is turned on. Speaker volume is set to 2 and channel number is set to 1."
        
    smartDevice = SmartLightDevice("Google Light", "Utility")
    smartDevice.turnOn()
}





