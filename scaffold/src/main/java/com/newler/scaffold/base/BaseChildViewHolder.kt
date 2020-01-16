package com.newler.scaffold.base

import android.view.View

/**
 *
 * @what
 * @author 17173
 * @date 2020/1/16
 *
 */
internal class BaseChildViewHolder<ChildItemData>(
    private val view: View,
    private val viewHolder: BaseViewHolder<Any>
) {
    private var childData: ChildItemData ?= null

    fun getChildData() = childData

    fun getParentViewHolder() = viewHolder

    fun setChildData(childItemData: ChildItemData) {
        this.childData = childItemData
    }
}