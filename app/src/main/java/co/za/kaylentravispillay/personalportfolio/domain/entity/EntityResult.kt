package co.za.kaylentravispillay.personalportfolio.domain.entity

import co.za.kaylentravispillay.personalportfolio.data.dto.DTOResult

private const val DEFAULT_ERROR_MESSAGE = "Unfortunately something has gone wrong. Please try again later."

sealed class EntityResult<in T> {
    data class Success<T>(val response: T) : EntityResult<T>()
    data class Error<T>(val status: Int, val message: String): EntityResult<T>()
}

fun <DTO, ENTITY> DTOResult<DTO>.mapToEntityResult(
    onMapDTOResponse: (DTO) -> ENTITY
): EntityResult<ENTITY> {
    return when (val result = this@mapToEntityResult) {
        is DTOResult.Success -> EntityResult.Success(response = onMapDTOResponse(result.response))
        is DTOResult.Error -> EntityResult.Error(
            status = result.status,
            message = if (result.message.isNotBlank()) {
                result.message
            } else {
                DEFAULT_ERROR_MESSAGE
            }
        )
    }
}
