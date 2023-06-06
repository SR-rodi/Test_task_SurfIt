package ru.sr.surfit.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.sr.surfit.di.dispatcherWrapperModule
import ru.sr.surfit.di.locationDataBaseModule
import ru.sr.surfit.di.mainModule
import ru.sr.surrfit.di.ratingModule

class SurfApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SurfApp)
            modules(
                mainModule() + ratingModule()
            )
        }
    }
}