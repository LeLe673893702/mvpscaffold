package com.newler.scaffold.base.state

import com.newler.scaffold.base.BaseActivity
import com.newler.scaffold.base.BasePresenter
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