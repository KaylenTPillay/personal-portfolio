package co.za.kaylentravispillay.personalportfolio.domain.entity

sealed class EntityResult<in T> {
    data class Success<T>(val response: T) : EntityResult<T>()
    data class Error<T>(val status: Int, val message: String): EntityResult<T>()
}
