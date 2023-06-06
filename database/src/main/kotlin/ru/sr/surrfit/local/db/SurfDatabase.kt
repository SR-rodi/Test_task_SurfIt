package ru.sr.surrfit.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.sr.surrfit.local.dao.RatingDao
import ru.sr.surrfit.local.entity.RatingEntity

@Database(
    entities = [
        RatingEntity::class
    ], version = 1
)
abstract class SurfDatabase : RoomDatabase() {

    abstract fun ratingDao(): RatingDao
}