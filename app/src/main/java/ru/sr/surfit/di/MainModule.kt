package ru.sr.surfit.di

import androidx.room.Room
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.sr.surfit.presentation.MainViewModel
import ru.sr.surrfit.dispatcherwrapper.CoroutineDispatchersWrapper
import ru.sr.surrfit.dispatcherwrapper.SurfDispatcher
import ru.sr.surrfit.firstrunlistener.FirstRunListener
import ru.sr.surrfit.firstrunlistener.FirstRunListenerImpl
import ru.sr.surrfit.local.db.SurfDatabase

fun mainModule() =
    listOf(
        locationDataBaseModule(),
        firstRunListenerModule(),
        dispatcherWrapperModule(),
        mainViewModelModule()
    )

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

fun firstRunListenerModule() = module {
    factoryOf(::FirstRunListenerImpl) { bind<FirstRunListener>() }
}

fun dispatcherWrapperModule() = module {
    singleOf(::CoroutineDispatchersWrapper) { bind<SurfDispatcher>() }
}

fun mainViewModelModule() = module {
    viewModelOf(::MainViewModel)
}