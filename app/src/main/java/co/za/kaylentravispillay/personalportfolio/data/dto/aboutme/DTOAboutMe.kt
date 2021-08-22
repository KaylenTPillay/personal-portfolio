package co.za.kaylentravispillay.personalportfolio.data.dto.aboutme

import com.google.gson.annotations.SerializedName

data class DTOAboutMe(
    @SerializedName(value = "profile")
    val profile: DTOAboutMeProfile = DTOAboutMeProfile(),

    @SerializedName(value = "sections")
    val sections: List<DTOAboutMeSection> = emptyList()
)