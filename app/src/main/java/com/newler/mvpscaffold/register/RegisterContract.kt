package com.newler.mvpscaffold.register

import com.newler.scaffold.base.BasePresenter
import com.newler.scaffold.base.BaseView

/**
 *
 * @what
 * @author 17173
 * @date 2020/1/9
 *
 */
interface RegisterContract {
    interface View : BaseView {

    }

    interface Presenter: BasePresenter {
        fun register(username: String,
                      email: String,
                      password_confirmation: String,
                      password: String)
    }
}