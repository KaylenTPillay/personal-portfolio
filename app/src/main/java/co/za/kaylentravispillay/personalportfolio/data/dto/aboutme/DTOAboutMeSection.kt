package co.za.kaylentravispillay.personalportfolio.data.dto.aboutme

import com.google.gson.annotations.SerializedName

data class DTOAboutMeSection(
    @SerializedName(value = "id")
    val id: String = String(),

    @SerializedName(value = "type")
    val type: String = String(),

    @SerializedName(value = "value")
    val value: Any = Any()
)