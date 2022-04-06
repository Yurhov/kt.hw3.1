fun main() {
    var phrase: String
    while (true) {
        print("Введите количество секунд или \"0\" для выхода: ")
        val time = readLine()?.toInt() ?: return
        when {
            time == 0 -> break
            time <= 60 -> phrase = "только что"
            time > 60 * 60 * 24 * 3 + 1 -> phrase = "давно"
            time > 60 * 60 * 24 * 2 + 1 -> phrase = "вчера"
            time > 60 * 60 * 24 + 1 -> phrase = "сегодня"
            time > 60 * 60 + 1 -> phrase = hourPhrase(time)
            time > 61 -> phrase = minutePhrase(time)
            else -> error("Неверно введено время")
        }
        println("был(а) в сети $phrase")
    }
}

fun hourPhrase(time: Int): String {
    val hour = (time / 3600)
    return when (hour) {
        1, 21 -> "$hour час назад"
        2, 3, 4, 22, 23 -> "$hour часа назад"
        else -> "$hour часов назад"
    }
}

fun minutePhrase(time: Int): String {
    val minute = (time / 60)
    return if (minute % 10 == 1 && minute != 11) "$minute минуту назад"
    else if (minute == 12 || minute == 13 || minute == 14) "$minute минут назад"
    else {
        when (minute % 10) {
            2, 3, 4 -> "$minute минуты назад"
            else -> "$minute минут назад"
        }
    }
}