package co.za.kaylentravispillay.personalportfolio.domain.entity.project

data class EntityProject(
    val id: String = String(),
    val name: String = String(),
    val description: String = String(),
    val link: String = String(),
    val starCount: Int = 0,
    val watcherCount: Int = 0
)