package com.mock.sample.mock


sealed class APIResponse<T>(val data: T? = null, val error: Throwable? = null) {
    class Success<T>(data: T) : APIResponse<T>(data = data)
    class Error<T>(error: Throwable) : APIResponse<T>(error = error)

}
