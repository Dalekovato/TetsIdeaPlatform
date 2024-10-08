package com.example.tetsideaplatform.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tetsideaplatform.domain.model.Item
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Entity(tableName = "item")
data class ItemDb (
    @PrimaryKey val id: Int,
    val name: String,
    val time: Long,
    val tags: List<String>,
    val amount: Int
)

fun ItemDb.toEntity() = Item(id = id, name = name, time = time.toTime(), tags = tags, amount = amount)

fun Item.toModel() = ItemDb(id = id, name = name, time = time.toMillis(), tags = tags, amount = amount)

fun Long.toTime(): String {
    val date = Date(this)
    val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
    val formattedDate = dateFormat.format(date)

    return formattedDate
}

fun String.toMillis(): Long {
    val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
    val date: Date? = dateFormat.parse(this)
    return date?.time ?: throw IllegalArgumentException("Invalid date format")
}