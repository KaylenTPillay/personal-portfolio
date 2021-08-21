package co.za.kaylentravispillay.personalportfolio.ui.util.itemdecoration.spaceaware.adapter

import co.za.kaylentravispillay.personalportfolio.ui.util.itemdecoration.spaceaware.model.UIModelSpaceAware

interface AdapterSpaceAware {
    fun getSpaceAwareItemTypeForPosition(position: Int?): Int?

    fun getSpaceAwareItemModelForPosition(position: Int?): UIModelSpaceAware?
}