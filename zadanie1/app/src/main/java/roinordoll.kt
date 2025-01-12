import kotlin.random.Random

// Interfejs RollingTool
interface RollingTool {
    fun roll(): String
}

// Klasa Coin dziedzicząca po RollingTool
class Coin : RollingTool {
    override fun roll(): String {
        return if (Random.nextBoolean()) "Heads" else "Tails"
    }
}

// Klasa Dice dziedzicząca po RollingTool
class Dice : RollingTool {
    override fun roll(): String {
        return (1..6).random().toString()
    }
}

// Funkcja do obsługi użytkownika
fun main() {
    while (true) {
        println("\nWybierz opcję:")
        println("1. Rzut monetą")
        println("2. Rzut kością")
        println("3. Wyjście")

        val choice = readLine()

        when (choice) {
            "1" -> {
                val coin = Coin()
                println("Wynik rzutu monetą: ${coin.roll()}")
            }
            "2" -> {
                val dice = Dice()
                println("Wynik rzutu kością: ${dice.roll()}")
            }
            "3" -> {
                println("Dziękujemy za skorzystanie z aplikacji!")
                break
            }
            else -> println("Niepoprawny wybór. Spróbuj ponownie.")
        }
    }
}
