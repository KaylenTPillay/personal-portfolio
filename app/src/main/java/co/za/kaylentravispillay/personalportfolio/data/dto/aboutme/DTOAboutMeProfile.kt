package co.za.kaylentravispillay.personalportfolio.data.dto.aboutme

import com.google.gson.annotations.SerializedName

data class DTOAboutMeProfile(
    @SerializedName(value = "name")
    val name: String = String(),

    @SerializedName("title")
    val title: String = String(),

    @SerializedName("image")
    val image: String = String()
)