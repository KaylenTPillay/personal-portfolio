package co.za.kaylentravispillay.personalportfolio.data.dto.aboutme

import com.google.gson.annotations.SerializedName

data class DTOAboutMeProfile(
    @SerializedName(value = "name")
    val name: String? = null,

    @SerializedName("title")
    val title: String? = null,

    @SerializedName("image")
    val image: String? = null,

    @SerializedName("github_username")
    val github_username: String? = null
)