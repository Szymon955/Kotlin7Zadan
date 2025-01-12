// Singleton
object Quotes {
    // Lista cytatów
    private val quotesList = mutableListOf(
        "Ciężka praca popłaca",
        "Lewy to maszyna",
        "Kotlin to super język",

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

git
