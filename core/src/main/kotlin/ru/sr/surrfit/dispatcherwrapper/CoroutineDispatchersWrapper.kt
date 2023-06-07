package ru.sr.surrfit.dispatcherwrapper

import kotlinx.coroutines.Dispatchers

class CoroutineDispatchersWrapper : SurfDispatcher {
    override val io = Dispatchers.IO
}