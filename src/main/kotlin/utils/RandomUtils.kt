package utils

object RandomUtils {
    fun getRandomNumber(bound: Int): Int {
        return (Math.random() * bound).toInt()
    }
}