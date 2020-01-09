package com.newler.mvpscaffold.register

import com.newler.scaffold.base.BaseFragment
import com.newler.scaffold.base.BasePresenter
import com.newler.mvpscaffold.R

class RegisterActivity : BaseFragment<BasePresenter>(), RegisterContract.View {

    override fun initView() {
    }

    override fun registerEvent() {
    }

    override fun unRegisterEvent() {
    }

    override fun getLayoutId()=R.layout.user_activity_register
}
