package co.za.kaylentravispillay.personalportfolio.aboutme.container.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import co.za.kaylentravispillay.personalportfolio.aboutme.container.diff.AboutMeItemDiff
import co.za.kaylentravispillay.personalportfolio.aboutme.container.model.UIModelAboutMeItem
import co.za.kaylentravispillay.personalportfolio.aboutme.container.model.UIModelAboutMeItemType
import co.za.kaylentravispillay.personalportfolio.aboutme.container.model.UIModelAboutMeParagraph
import co.za.kaylentravispillay.personalportfolio.aboutme.container.model.UIModelAboutMeTitle
import co.za.kaylentravispillay.personalportfolio.aboutme.container.viewholder.base.ViewHolderAboutMe
import co.za.kaylentravispillay.personalportfolio.aboutme.container.viewholder.text.ViewHolderAboutMeText
import co.za.kaylentravispillay.personalportfolio.util.itemdecoration.spaceaware.adapter.AdapterSpaceAware
import co.za.kaylentravispillay.personalportfolio.util.itemdecoration.spaceaware.model.UIModelSpaceAware

class AdapterAboutMe : ListAdapter<UIModelAboutMeItem, RecyclerView.ViewHolder>(
    AboutMeItemDiff()
), AdapterSpaceAware {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return when (viewType) {
            UIModelAboutMeItemType.TEXT.ordinal -> createTextViewHolder(parent)
            else -> createUnknownViewHolder(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = currentList[position]
        (holder as? ViewHolderAboutMe)?.onBindViewHolder(model)
    }

    override fun getItemViewType(position: Int): Int {
        val model = currentList[position]
        return when (model) {
            is UIModelAboutMeTitle, is UIModelAboutMeParagraph -> UIModelAboutMeItemType.TEXT
            else -> UIModelAboutMeItemType.UNKNOWN
        }.ordinal
    }

    override fun getSpaceAwareItemTypeForPosition(position: Int?): Int? {
        position ?: return null
        currentList.getOrNull(position) ?: return null
        return getItemViewType(position)
    }

    override fun getSpaceAwareItemModelForPosition(position: Int?): UIModelSpaceAware? {
        position ?: return null
        return currentList.getOrNull(position)
    }

    private fun createTextViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ViewHolderAboutMeText(parent.context)
    }

    private fun createUnknownViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return object : RecyclerView.ViewHolder(View(parent.context)) {}
    }
}