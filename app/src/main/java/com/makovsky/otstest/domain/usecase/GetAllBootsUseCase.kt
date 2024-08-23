package com.makovsky.otstest.domain.usecase

import com.makovsky.otstest.domain.entities.Boot
import com.makovsky.otstest.domain.repository.MainRepository
import com.makovsky.otstest.utils.Either

class GetAllBootsUseCase(
    private val mainRepository: MainRepository
): BaseUseCase<List<Boot>, BaseUseCase.None>() {
    override suspend fun run(param: None): Either<Any, List<Boot>> {
        return try {
            val bootList = mainRepository.getAllBoots().map {
                Boot(
                    time = it.time
                )
            }
            Either.Right(bootList)
        } catch (exception: Exception){
            Either.Left(onWrapException(exception))
        }
    }
}