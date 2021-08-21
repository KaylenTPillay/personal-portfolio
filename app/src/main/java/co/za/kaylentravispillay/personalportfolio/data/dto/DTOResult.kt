package co.za.kaylentravispillay.personalportfolio.data.dto

sealed class DTOResult<in T> {
    data class Success<T>(val response: T) : DTOResult<T>()
    data class Error<T>(val status: Int, val message: String) : DTOResult<T>()
}