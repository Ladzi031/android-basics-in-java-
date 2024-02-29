fun main() {
    repeat(3){
        println("hello ladzani!")
    }
    val coins: (Int) -> String = { quantity -> "${quantity} quarters" }
    
    
    val treatFunction = trickOrTreat(false, extraTreat = coins) // the function-literal, is now passed to the extraTreat argument
    val trickFunction = trickOrTreat(true, null)
    
    treatFunction()
    
    trickFunction()
    
    val syntaxSugar = trickOrTreat(false) {"${it} quarters"}
    syntaxSugar()
    
}
fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit { // second-argument(a.k.a extraTreat) is nullable...
    if(isTrick) {
        return trick
    }else {
       if(extraTreat != null) {
            println(extraTreat(5))
       }
        return treat
    }
}

val trick = {
    println("No treats!")
}
val treat: () -> Unit = {
    println("Have a treat!")
}
