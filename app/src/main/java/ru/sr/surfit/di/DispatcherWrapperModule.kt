package ru.sr.surfit.di

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.sr.surrfit.dispatcherwrapper.CoroutineDispatchersWrapper
import ru.sr.surrfit.dispatcherwrapper.SurfDispatcher

fun dispatcherWrapperModule() = module {
    singleOf(::CoroutineDispatchersWrapper) { bind<SurfDispatcher>() }
}