package com.newler.mvpscaffold

import io.reactivex.ObservableTransformer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *
 * @what
 * @author 17173
 * @date 2020/1/9
 *
 */
class RxUtil {
    companion object {
        fun <T>applySchedulers() = ObservableTransformer<T, T> {
                it.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }
}
