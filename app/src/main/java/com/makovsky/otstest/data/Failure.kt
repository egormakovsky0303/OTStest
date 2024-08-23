package com.makovsky.otstest.data

sealed class Failure(val exception: Exception) {
    open class UnknownFailure(exception: Exception) : Failure(exception)
}