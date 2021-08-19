package co.za.kaylentravispillay.personalportfolio.util.itemdecoration.spaceaware.adapter

import co.za.kaylentravispillay.personalportfolio.util.itemdecoration.spaceaware.model.UIModelSpaceAware

interface AdapterSpaceAware {
    fun getSpaceAwareItemTypeForPosition(position: Int?): Int?

    fun getSpaceAwareItemModelForPosition(position: Int?): UIModelSpaceAware?
}