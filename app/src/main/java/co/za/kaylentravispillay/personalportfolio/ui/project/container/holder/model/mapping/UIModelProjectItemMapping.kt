package co.za.kaylentravispillay.personalportfolio.ui.project.container.holder.model.mapping

import co.za.kaylentravispillay.personalportfolio.domain.entity.project.EntityProject
import co.za.kaylentravispillay.personalportfolio.ui.project.container.holder.model.UIModelProjectItem

fun List<EntityProject>.mapToUIModels(): List<UIModelProjectItem> {
    return this@mapToUIModels.mapIndexed { index, entityProject ->
        entityProject.mapToUIModel(index)
    }
}

private fun EntityProject.mapToUIModel(index: Int = -1): UIModelProjectItem {
    return UIModelProjectItem(
        id = if (index != -1) index.toString() else this@mapToUIModel.id,
        title = this@mapToUIModel.name,
        description = this@mapToUIModel.description,
        link = this@mapToUIModel.link,
        watchers = this@mapToUIModel.watcherCount,
        stars = this@mapToUIModel.starCount,
        isLoading = false
    )
}