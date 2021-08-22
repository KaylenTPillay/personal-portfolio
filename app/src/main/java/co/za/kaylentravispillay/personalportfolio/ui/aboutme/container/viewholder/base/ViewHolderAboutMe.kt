package co.za.kaylentravispillay.personalportfolio.ui.aboutme.container.viewholder.base

import android.view.View
import androidx.annotation.StyleRes
import androidx.core.widget.TextViewCompat
import androidx.recyclerview.widget.RecyclerView
import co.za.kaylentravispillay.personalportfolio.ui.aboutme.container.model.UIModelAboutMeItem
import com.google.android.material.textview.MaterialTextView

abstract class ViewHolderAboutMe(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    abstract fun onBindViewHolder(model: UIModelAboutMeItem)

    protected fun bindTextStyle(view: MaterialTextView, @StyleRes styleRes: Int) {
        TextViewCompat.setTextAppearance(view, styleRes)
    }

    protected open fun onViewHolderAttached() {}
    protected open fun onViewHolderDetached() {}
}