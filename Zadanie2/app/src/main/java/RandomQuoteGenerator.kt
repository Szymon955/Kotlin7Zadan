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