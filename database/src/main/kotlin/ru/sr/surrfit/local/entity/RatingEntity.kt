package ru.sr.surrfit.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rating")
class RatingEntity(
    @ColumnInfo(name = "mode")
    val mode: String,
    @ColumnInfo(name = "stepCount")
    val stepCount: Int,
    @ColumnInfo(name = "name")
    val userName: String,
    @ColumnInfo(name = "email")
    val email: String,
    @PrimaryKey
    @ColumnInfo(name = "position")
    val id: Int? = null,
)