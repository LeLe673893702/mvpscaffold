package com.newler.scaffold.base.state

import androidx.fragment.app.FragmentActivity
import com.llc.smartterminal.base.BaseView
import com.uber.autodispose.AutoDisposeConverter

interface BaseStateView : BaseView {
    fun showLoadFailed()
    fun showContent()
    fun showLoading()
    fun showEmpty()
}