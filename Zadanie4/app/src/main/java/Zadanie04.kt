// Interfejs reprezentujący typ pogody
interface Pogoda {
    fun wyswietlPrognoze(): String
}

// Implementacje różnych typów pogody
class Sloneczna : Pogoda {
    override fun wyswietlPrognoze() = "Dziś jest słoneczny dzień!"
}

class Deszczowa : Pogoda {
    override fun wyswietlPrognoze() = "Pada deszcz"
}

class Pochmurna : Pogoda {
    override fun wyswietlPrognoze() = "Jest pochmurno"
}

// Data class reprezentująca miasto i przypisaną pogodę
data class Miasto(val nazwa: String, val pogoda: Pogoda)

fun aplikacjaPogodowa() {
    // Lista miast z przypisaną prognozą pogody
    val miasta = listOf(
        Miasto("Warszawa", Sloneczna()),
        Miasto("Kraków", Deszczowa()),
        Miasto("Gdańsk", Pochmurna())
    )

    println("Wybierz miasto, aby zobaczyć prognozę pogody:")
    miasta.forEachIndexed { index, miasto -> println("${index + 1}. ${miasto.nazwa}") }

    // Pobranie wyboru użytkownika
    val wybor = readLine()?.toIntOrNull()
    if (wybor != null && wybor in 1..miasta.size) {
        val wybraneMiasto = miasta[wybor - 1]
        println("Pogoda w ${wybraneMiasto.nazwa}: ${wybraneMiasto.pogoda.wyswietlPrognoze()}")
    } else {
        println("Nieprawidłowy wybór.")
    }
}

fun main(){
    aplikacjaPogodowa()
}
