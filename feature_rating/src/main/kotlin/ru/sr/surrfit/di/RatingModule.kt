package ru.sr.surrfit.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.sr.surrfit.data.repository.RatingLocalRepositoryImpl
import ru.sr.surrfit.domain.repository.RatingLocalRepository
import ru.sr.surrfit.domain.usecase.GetRatingUseCase
import ru.sr.surrfit.domain.usecase.impl.GetRatingUseCaseImpl
import ru.sr.surrfit.presentation.viewmodel.RatingViewModel

fun ratingModule() = listOf(repositoryModule(), useCaseModule(), viewModelModule())

internal fun repositoryModule() = module {
    singleOf(::RatingLocalRepositoryImpl) { bind<RatingLocalRepository>() }
}

internal fun useCaseModule() = module {
    singleOf(::GetRatingUseCaseImpl) { bind<GetRatingUseCase>() }
}

internal fun viewModelModule() = module {
    viewModelOf(::RatingViewModel)
}