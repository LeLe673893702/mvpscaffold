package com.newler.mvpscaffold.register

import android.util.Log
import com.newler.mvpscaffold.RxUtil
import com.newler.mvpscaffold.data.UserService
import javax.inject.Inject

/**
 *
 * @what
 * @author 17173
 * @date 2020/1/9
 *
 */
class RegisterPresenter @Inject constructor(
     val view : RegisterContract.View,
     val service: UserService
) : RegisterContract.Presenter {
    override fun register(
        username: String,
        email: String,
        password_confirmation: String,
        password: String
    ) {
        service.register(username, email, password_confirmation, password)
            .compose(RxUtil.applySchedulers())
            .`as`(view.autoDispose())
            .subscribe {
                Log.e("RegisterPresenter", it)
            }

    }

    override fun onStart() {
    }

    override fun onDestroy() {
    }
}