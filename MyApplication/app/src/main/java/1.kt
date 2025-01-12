fun flipCoin(): String {
    return if ((0..1).random() == 0) "Heads" else "Tails"
}

fun rollDice(): Int {
    return (1..6).random()
}

fun main() {
    println("Coin flip result: ${flipCoin()}")
    println("Dice roll result: ${rollDice()}")
}
