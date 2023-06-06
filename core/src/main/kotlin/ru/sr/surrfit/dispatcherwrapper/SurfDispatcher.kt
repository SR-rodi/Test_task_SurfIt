package ru.sr.surrfit.dispatcherwrapper

import kotlinx.coroutines.CoroutineDispatcher

interface SurfDispatcher {
    val io: CoroutineDispatcher
}