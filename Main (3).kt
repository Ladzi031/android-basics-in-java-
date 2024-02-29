fun main() {
    val morningNotification = 51
    val eveningNotification = 135
    
    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
    printNotificationSummary(0)
    printNotificationSummary(1000)
}


fun printNotificationSummary(numberOfMessages: Int) {
    when (numberOfMessages) {
        0 -> println("You have No notifications.")
        in 1..99 -> println("You have ${numberOfMessages} notifications.")
        else -> println("Your phone is blowing up! You have 99+ notifications.")
    }
}
