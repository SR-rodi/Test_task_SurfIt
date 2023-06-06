package ru.sr.surrfit.local

import ru.sr.surrfit.local.entity.RatingEntity
import kotlin.random.Random

object ItemsGeneration {

    private val names = listOf(
        "Валера",
        "Матвей",
        "Гриша",
        "Егор",
        "Никита",
        "Дима",
        "Светлана",
        "Тюлень",
        "Стас",
        "Марина",
        "Катя",
        "Вика",
        "Тамара",
        "Аглая",
        "Наталья",
        "Виталик",
        "Мария"
    )
    private val modes = listOf("Случайный", "Классический", "Сложный", "Невыносимый")
    private val emailStart = listOf(
        "test_",
        "manager_",
        "povelitel_",
        "developer_",
        "dns_user",
        "abricoscka_",
        "varvar_"
    )
    private val email_last = listOf("@mail.ru", "@yandex,ru")

    fun getItems(repeatCounter: Int): List<RatingEntity> {
        val items = mutableListOf<RatingEntity>()
        repeat(repeatCounter) {
            val email = emailStart[Random.nextInt(0, emailStart.lastIndex)]+
                    Random.nextInt(1000, 9999).toString() +
                    email_last[Random.nextInt(0, email_last.lastIndex)]

            val item = RatingEntity(
                mode = modes[Random.nextInt(0, modes.lastIndex)],
                stepCount = Random.nextInt(200, 1000),
                userName = names[Random.nextInt(0, modes.lastIndex)],
                email = email
            )
            items.add(item)
        }
        return items
    }
}