package co.za.kaylentravispillay.personalportfolio.data.dto.aboutme

import com.google.gson.annotations.SerializedName

data class DTOAboutMeSection(
    @SerializedName(value = "id")
    val id: String? = null,

    @SerializedName(value = "type")
    val type: String? = null,

    @SerializedName(value = "value")
    val value: Any? = null
)