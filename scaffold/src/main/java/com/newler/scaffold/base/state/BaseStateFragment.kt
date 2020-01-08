package com.llc.smartterminal.base.state

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.llc.smartterminal.base.BaseFragment
import com.newler.state.StateManager

/**
 *
 * @what
 * @author newler
 * @date 2019/12/13
 *
 */
abstract class BaseStateFragment<T : BaseStatePresenter> : BaseFragment<T>() {
    protected val holder by lazy {
        view?.let {
            StateManager.instance.wrap(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val child: View = inflater.inflate(getLayoutId(),container, false)

        return child
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        holder?.withRetryListener(Runnable {
            mPresenter?.onRetry()
        })
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
        holder?.showContent()
    }

}