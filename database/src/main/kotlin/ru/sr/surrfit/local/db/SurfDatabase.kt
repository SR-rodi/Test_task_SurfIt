package ru.sr.surrfit.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
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

    companion object {
        fun getInstance(context: Context): SurfDatabase {
           return Room.databaseBuilder(
                context,
                SurfDatabase::class.java,
                "list"
            ).build()
        }
    }
}