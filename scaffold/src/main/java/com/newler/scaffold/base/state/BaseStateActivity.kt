package com.llc.smartterminal.base.state

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.llc.smartterminal.base.BaseActivity
import com.llc.smartterminal.base.BasePresenter
import com.newler.state.StateManager

/**
 *
 * @what
 * @author newler
 * @date 2019/12/13
 *
 */
abstract class BaseStateActivity<T : BasePresenter> : BaseActivity<T>() {
    protected val holder by lazy {
        StateManager.instance.wrap(this)
    }

    fun showLoadFailed() {
        holder?.showLoadFailed()
    }

    fun showContent() {
        holder?.showContent()
    }

    fun showLoading() {
        holder?.showLoading()
    }

    fun showEmpty() {
        holder?.showEmpty()
    }

}