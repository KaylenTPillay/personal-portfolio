package co.za.kaylentravispillay.personalportfolio.data.dto

import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Response

sealed class DTOResult<in T> {
    data class Success<T>(val response: T) : DTOResult<T>()
    data class Error<T>(val status: Int, val message: String) : DTOResult<T>()
}

fun <DTO> Response<DTO>.mapToDTOResult(): DTOResult<DTO> {
    return if (this@mapToDTOResult.isSuccessful) {
        DTOResult.Success(response = this@mapToDTOResult.body())
    } else {
        DTOResult.Error(
            status = this@mapToDTOResult.code(),
            message = this@mapToDTOResult.errorBody()?.mapToMessage() ?: this@mapToDTOResult.message()
        )
    }
}

private fun ResponseBody.mapToMessage(): String? {
    return try {
        JSONObject(this@mapToMessage.string()).getString("message")
    } catch (exp: Exception) {
        null
    }
}