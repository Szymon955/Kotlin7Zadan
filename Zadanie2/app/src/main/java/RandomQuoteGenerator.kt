object Quotes {
    // Lista cytatów
    private val quotesList = mutableListOf(
        "Ciężka praca popłaca",
        "Ból jest tymczasowy, chwała jest wieczna.",
        "Lewandowski to szef"
    )

    // Metoda zwracająca losowy cytat
    fun getRandomQuote(): String {
        return quotesList.random()
    }

    // Metoda dodająca nowy cytat do bazy
    fun addQuote(newQuote: String) {
        quotesList.add(newQuote)
    }
}

fun main() {
    while (true) {
        println("\nWybierz opcję:")
        println("1. Wylosuj cytat")
        println("2. Dodaj nowy cytat")
        println("3. Wyjście")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                println("\nLosowy cytat: ${Quotes.getRandomQuote()}")
            }
            2 -> {
                print("\nWpisz nowy cytat: ")
                val newQuote = readLine()
                if (!newQuote.isNullOrBlank()) {
                    Quotes.addQuote(newQuote)
                    println("Nowy cytat został dodany.")
                } else {
                    println("Cytat nie może być pusty.")
                }
            }
            3 -> {
                println("Do widzenia!")
                break
            }
            else -> {
                println("Nieprawidłowy wybór. Spróbuj ponownie.")
            }
        }
    }
}