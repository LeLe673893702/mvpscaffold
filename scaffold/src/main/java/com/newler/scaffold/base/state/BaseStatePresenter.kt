package com.llc.smartterminal.base.state

import android.content.Context
import com.llc.smartterminal.base.BasePresenter

/**
 *
 * @what
 * @author newler
 * @date 2019/12/13
 *
 */
interface BaseStatePresenter : BasePresenter {
    fun onLoadData()
    fun onRetry()
}