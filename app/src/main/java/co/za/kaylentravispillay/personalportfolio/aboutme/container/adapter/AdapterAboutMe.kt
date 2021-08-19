package co.za.kaylentravispillay.personalportfolio.aboutme.container.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import co.za.kaylentravispillay.personalportfolio.aboutme.container.diff.AboutMeItemDiff
import co.za.kaylentravispillay.personalportfolio.aboutme.container.model.UIModelAboutMeItem
import co.za.kaylentravispillay.personalportfolio.aboutme.container.model.UIModelAboutMeParagraph
import co.za.kaylentravispillay.personalportfolio.aboutme.container.model.UIModelAboutMeTitle
import co.za.kaylentravispillay.personalportfolio.aboutme.container.viewholder.base.ViewHolderAboutMe
import co.za.kaylentravispillay.personalportfolio.aboutme.container.viewholder.text.ViewHolderAboutMeText

class AdapterAboutMe : ListAdapter<UIModelAboutMeItem, RecyclerView.ViewHolder>(AboutMeItemDiff()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return when (viewType) {
            ItemType.TEXT.ordinal -> createTextViewHolder(parent)
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
            is UIModelAboutMeTitle, is UIModelAboutMeParagraph -> ItemType.TEXT
            else -> ItemType.UNKNOWN
        }.ordinal
    }

    private fun createTextViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ViewHolderAboutMeText(parent.context)
    }

    private fun createUnknownViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return object : RecyclerView.ViewHolder(View(parent.context)) {}
    }

    private enum class ItemType {
        UNKNOWN,
        TEXT
    }
}