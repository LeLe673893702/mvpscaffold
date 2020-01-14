package com.newler.scaffold.base

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 *
 * @what
 * @author 17173
 * @date 2020/1/14
 *
 */
class BaseViewHolder<ItemData>(view: View) : RecyclerView.ViewHolder(view) {
    private var itemData: ItemData?=null
    protected val context: Context by lazy {
        itemView.context
    }

    fun getItemData() = itemData

    fun setItemData(itemData: ItemData) {
        this.itemData = itemData
    }
}