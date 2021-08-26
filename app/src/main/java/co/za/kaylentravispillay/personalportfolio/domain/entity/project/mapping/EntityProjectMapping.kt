package co.za.kaylentravispillay.personalportfolio.domain.entity.project.mapping

import co.za.kaylentravispillay.personalportfolio.data.dto.project.DTOProject
import co.za.kaylentravispillay.personalportfolio.domain.entity.project.EntityProject

fun List<DTOProject>.mapToEntityProjects(): List<EntityProject> {
    return this@mapToEntityProjects.map { dtoProject -> dtoProject.mapToEntityProject() }
}

private fun DTOProject.mapToEntityProject(): EntityProject {
    return EntityProject(
        id = this@mapToEntityProject.id ?: String(),
        name = this@mapToEntityProject.name ?: String(),
        description = this@mapToEntityProject.description ?: String(),
        link = this@mapToEntityProject.html_url ?: String(),
        starCount = this@mapToEntityProject.stargazers_count ?: 0,
        watcherCount = this@mapToEntityProject.watchers_count ?: 0
    )
}