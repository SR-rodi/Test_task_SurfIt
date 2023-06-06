package ru.sr.surfit.di

import androidx.room.Room
import org.koin.dsl.module
import ru.sr.surrfit.local.db.SurfDatabase

fun locationDataBaseModule() = module {
    single {
        Room.databaseBuilder(
            get(),
            SurfDatabase::class.java,
            "list"
        ).build()
    }

    single {
        get<SurfDatabase>().ratingDao()
    }
}