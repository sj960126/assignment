package com.shs.data.network.extension

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow


sealed class ApiResult<out T> {
    data class Success<out T>(val data: T): ApiResult<T>()
    data class Error(val exception: Throwable? = null): ApiResult<Nothing>()
}

inline fun <T> safeFlow(crossinline networkCall: suspend () -> T): Flow<ApiResult<T>> = flow {
    val result = networkCall()
    if (result != null) {
        emit(ApiResult.Success(result))
    } else {
        emit(ApiResult.Error(NullPointerException("Network call returned null")))
    }
}.catch { exception ->
    emit(ApiResult.Error(exception))
}
