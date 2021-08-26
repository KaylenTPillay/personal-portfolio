package co.za.kaylentravispillay.personalportfolio.data.dto.project

import com.google.gson.annotations.SerializedName

data class DTOProject(
    @SerializedName("id")
    val id: String? = null,

    @SerializedName(value = "name")
    val name: String? = null,

    @SerializedName(value = "description")
    val description: String? = null,

    @SerializedName(value = "url")
    val url: String? = null,

    @SerializedName(value = "stargazers_count")
    val stargazers_count: Int? = null,

    @SerializedName(value = "watchers_count")
    val watchers_count: Int? = null
)