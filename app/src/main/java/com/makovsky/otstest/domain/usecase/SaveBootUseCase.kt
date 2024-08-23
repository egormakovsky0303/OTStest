package com.makovsky.otstest.domain.usecase

import com.makovsky.otstest.domain.repository.MainRepository
import com.makovsky.otstest.utils.Either

class SaveBootUseCase(
    private val mainRepository: MainRepository
): BaseUseCase<Any, BaseUseCase.None>() {
    override suspend fun run(param: None): Either<Any, Any> {
        return try {
            val time = System.currentTimeMillis()
            Either.Right(mainRepository.saveBoot(time))
        } catch (exception: Exception){
            Either.Left(onWrapException(exception))
        }
    }
}