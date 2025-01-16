class StepCounter {

    companion object {
        var steps: Int = 50 // Licznik kroków
    }

    fun step() {
        steps++
        println("Zrobiłeś krok! Twoje kroki: $steps")
    }

    fun reset() {
        steps = 0
        println("Kroki zresetowane.")
    }
}

fun stepCounterApp() {
    val counter = StepCounter()

    while (true) {
        println("Wybierz opcje: \n1. Krok \n2. Reset \n3. Wyjście")
        when (readLine()?.toIntOrNull()) {
            1 -> counter.step()
            2 -> counter.reset()
            3 -> return
            else -> println("Nie prawidłowa opcja")
        }
    }
}
fun main() {
    stepCounterApp()
}
