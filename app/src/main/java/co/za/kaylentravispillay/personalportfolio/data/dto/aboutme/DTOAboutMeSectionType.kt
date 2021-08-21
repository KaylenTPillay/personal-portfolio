package co.za.kaylentravispillay.personalportfolio.data.dto.aboutme

enum class DTOAboutMeSectionType(private val value: String) {
    UNKNOWN(""),
    TITLE("title"),
    PARAGRAPH("paragraph");

    companion object {
        private val ENUM_LOOKUP: Map<String, DTOAboutMeSectionType> = HashMap<String, DTOAboutMeSectionType>().apply {
            values().forEach { type -> put(type.value, type) }
        }

        fun fromString(value: String) = ENUM_LOOKUP[value] ?: UNKNOWN
    }
}