package com.makovsky.otstest.domain.usecase

import androidx.lifecycle.LiveData
import com.makovsky.otstest.domain.entities.Boot
import com.makovsky.otstest.domain.repository.MainRepository
import com.makovsky.otstest.utils.Either

class GetLastBootUseCase(
    private val mainRepository: MainRepository
): BaseUseCase<LiveData<Boot?>, BaseUseCase.None>() {
    override suspend fun run(param: None): Either<Any, LiveData<Boot?>> {
        return try {
            Either.Right(mainRepository.getBoot())
        } catch (exception: Exception){
            Either.Left(onWrapException(exception))
        }
    }
}