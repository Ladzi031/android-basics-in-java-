import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun main() {
    val mySong = Song("dancing in the rain", "john kotlin", "2024")
    
    println("is song popular: ${mySong.isPopular}")
    mySong.getSongDescription()
    println("number of plays: ${mySong.playCount}")
    mySong.playCount = 45
    println("number of plays after a few minutes: ${mySong.playCount}")
  
    
}
class Song(private val title: String, private val artist: String, private val yearPublished: String) {
   
    var playCount by RangeDelegate(initialValue = 0, minValue = 0)
    
    var isPopular: Boolean = if(playCount > 1000) true else false
    
    
    fun getSongDescription() {
        println("[${title}], performed by [${artist}], was released in [${yearPublished}]")
    }
}
class RangeDelegate(initialValue: Int, private val minValue: Int) : ReadWriteProperty<Any?, Int> {
    var fieldData = initialValue
    
    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }
    
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if(value >= minValue) {
            fieldData = value
        }
    }
}