fun main() {    
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)
    val kotlin = Person("kotlin", 32, null, null)
    kotlin.showProfile()
    amanda.showProfile()
    atiqah.showProfile()
}


class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
       println("name: ${name}")
       println("Age: ${age}")
       checkForHobbyAndRef(hobby, referrer)
       println()
    }
    
    private fun checkForHobbyAndRef(personHobby: String?, referrer: Person?) {
        var hasHobbyRes = checkHobby(personHobby)
        var referreRes: String = "Doesn't have a referrer"
        if(referrer != null) {
            referreRes = "Has referrer named ${referrer.name} who ${checkHobby(referrer.hobby)}"
        }
        
        println("${hasHobbyRes} ${referreRes}")
        
    }
    private fun checkHobby(text: String?): String {
        return  if (text != null) "Likes to ${text}. " else "Has No hobbies. "
    }
}
