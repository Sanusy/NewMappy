package com.gmail.ivan.morozyk.mappy.model

sealed class MappyResponse<T> {
    class Success<T>(val data: T): MappyResponse<T>()
    class Error<T>(val error: Throwable?) : MappyResponse<T>()
}
