fun main() {
    Quiz().apply {
       printQuiz()
   }
    
}
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
) {
    
}
enum class Difficulty {
    EASY,
    MEDIUM,
    HARD
}
interface ProgressPrintable {
    val progressText: String
    fun progressBar()
}
class Quiz: ProgressPrintable {
    override val progressText: String 
    	get() = "${answered} of ${total} answered"
    
    val question1 = Question<String>("Quoth the raven _ _ _", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or False", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
    
   companion object StudentProgress {
        var total = 10
        var answered = 3
   }
   
   override fun progressBar() {
       repeat(Quiz.answered) {
           print("▓")
       }
       repeat(Quiz.total - Quiz.answered) {
        print("▒")
       }
      println()
      println(progressText)
   }
   
  fun printQuiz() {
      
      question1.let {
          println(it.questionText)
          println(it.answer)
          println(it.difficulty)
      }
      
      println()
      
      question2.let {
          println(it.questionText)
          println(it.answer)
          println(it.difficulty)
      }
    println()
    question3.let {
        println(it.questionText)
        println(it.answer)
        println(it.difficulty)
    }
    println()

  }
}
