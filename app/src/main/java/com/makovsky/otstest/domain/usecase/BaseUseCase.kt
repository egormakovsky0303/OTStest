package com.makovsky.otstest.domain.usecase

import com.makovsky.otstest.data.Failure
import com.makovsky.otstest.utils.Either
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

abstract class BaseUseCase<out Type, in Param> where Type : Any {

    abstract suspend fun run(param: Param): Either<Any, Type>

    open val dispatcher: CoroutineDispatcher = Dispatchers.Default

    open operator fun invoke(
        scope: CoroutineScope,
        param: Param,
        result: (Either<Any, Type>) -> Unit = {}
    ): Job {
        val backgroundJob = scope.async(dispatcher) { run(param) }
        return scope.launch(Dispatchers.Main) { result.invoke(backgroundJob.await()) }
    }

    protected fun onWrapException(exception: Exception): Any {
        return Failure.UnknownFailure(exception)
    }

    @Suppress("unused") //could be used in use cases without parameters
    class None
}