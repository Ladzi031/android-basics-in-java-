fun main() {
    val child = 5
    val adult = 28
    val senior = 87
    
    val isMonday = true
    
    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")
    println("The movie ticket price for a person aged $adult on (Tuesday - Sunday) is \$${ticketPrice(adult, false)}.")
    println("The movie ticket price for a person x is \$${ticketPrice(0, isMonday)}.")
}

fun ticketPrice(age: Int, isMonday: Boolean): Int {
    val price: Int = when (age) {
        in 1..12 -> 15
        in 13..60 -> {
            if(isMonday) {
                25
            }else {
                30
            }
        }
        in 61..100 -> 20
        else -> -1
    }
    return price
}
