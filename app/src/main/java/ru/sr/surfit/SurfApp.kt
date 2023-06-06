package ru.sr.surfit

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.sr.surfit.di.locationDataBaseModule

class SurfApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SurfApp)
            modules(
                listOf(locationDataBaseModule())
            )
        }
    }
}