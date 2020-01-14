package com.newler.mvpscaffold.register

import android.util.Log
import com.newler.mvpscaffold.DataManager
import com.newler.scaffold.base.BaseFragment
import com.newler.scaffold.base.BasePresenter
import com.newler.mvpscaffold.R
import com.newler.mvpscaffold.data.UserService
import com.newler.scaffold.base.BaseActivity
import kotlinx.android.synthetic.main.user_activity_register.*

class RegisterActivity : BaseActivity<RegisterContract.Presenter>(), RegisterContract.View {
    override fun initView() {
    }

    override fun registerEvent() {
        btSure.setOnClickListener {
            mPresenter?.register(
                etUser.text.toString(),
                etEmail.text.toString(),
                etPassword.text.toString(),
                etSurePassword.text.toString()
            )
        }

    }

    override fun unRegisterEvent() {
    }

    override fun getLayoutId()=R.layout.user_activity_register
    override fun getPresenter() = RegisterPresenter(this, DataManager.instance.getUserService())
}
