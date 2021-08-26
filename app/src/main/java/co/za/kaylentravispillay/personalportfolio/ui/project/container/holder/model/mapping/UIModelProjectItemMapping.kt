package co.za.kaylentravispillay.personalportfolio.ui.project.container.holder.model.mapping

import co.za.kaylentravispillay.personalportfolio.domain.entity.project.EntityProject
import co.za.kaylentravispillay.personalportfolio.ui.project.container.holder.model.UIModelProjectItem

fun List<EntityProject>.mapToUIModels(): List<UIModelProjectItem> {
    return this@mapToUIModels.map { entityProject -> entityProject.mapToUIModel() }
}

private fun EntityProject.mapToUIModel(): UIModelProjectItem {
    return UIModelProjectItem(
        id = this@mapToUIModel.id,
        title = this@mapToUIModel.name,
        description = this@mapToUIModel.description,
        link = this@mapToUIModel.link,
        watchers = this@mapToUIModel.watcherCount,
        stars = this@mapToUIModel.starCount
    )
}