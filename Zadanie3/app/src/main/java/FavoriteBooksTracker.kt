data class Ksiazka(val tytul: String, val autor: String, val rok: Int)

class ListaUlubionychKsiazek {
    private val ksiazki = mutableListOf<Ksiazka>()

    fun dodajKsiazke(tytul: String, autor: String, rok: Int) {
        ksiazki.add(Ksiazka(tytul, autor, rok))
        println("Dodano: \"$tytul\" autorstwa $autor ($rok)")
    }

    fun wyswietlKsiazki() {
        if (ksiazki.isEmpty()) println("Lista książek jest pusta.")
        else ksiazki.forEach { println("- ${it.tytul} autorstwa ${it.autor} (${it.rok})") }
    }

    fun filtrujPoAutorze(autor: String) =
        ksiazki.filter { it.autor.equals(autor, ignoreCase = true) }
            .forEach { println("- ${it.tytul} (${it.rok})") }

    fun filtrujPoRoku(rok: Int) =
        ksiazki.filter { it.rok == rok }
            .forEach { println("- ${it.tytul} autorstwa ${it.autor}") }

    fun sortujPoTytule() =
        ksiazki.sortedBy { it.tytul }
            .forEach { println("- ${it.tytul} autorstwa ${it.autor} (${it.rok})") }
}

fun main() {
    val lista = ListaUlubionychKsiazek()

    while (true) {
        println(
            """
            Wybierz opcję:
            1. Dodaj książkę
            2. Wyświetl wszystkie książki
            3. Filtruj książki po autorze
            4. Filtruj książki po roku wydania
            5. Sortuj książki alfabetycznie po tytule
            6. Wyjdź
        """.trimIndent()
        )
        when (readLine()?.toIntOrNull()) {
            1 -> {
                print("Podaj tytuł: "); val tytul = readLine().orEmpty()
                print("Podaj autora: "); val autor = readLine().orEmpty()
                print("Podaj rok wydania: "); val rok = readLine()?.toIntOrNull() ?: continue
                lista.dodajKsiazke(tytul, autor, rok)
            }
            2 -> lista.wyswietlKsiazki()
            3 -> {
                print("Podaj autora: "); val autor = readLine().orEmpty()
                lista.filtrujPoAutorze(autor)
            }
            4 -> {
                print("Podaj rok wydania: "); val rok = readLine()?.toIntOrNull() ?: continue
                lista.filtrujPoRoku(rok)
            }
            5 -> lista.sortujPoTytule()
            6 -> break
            else -> println("Nieprawidłowa opcja. Spróbuj ponownie.")
        }
    }
}
