package com.newler.mvpscaffold

import com.newler.mvpscaffold.data.UserApi
import com.newler.mvpscaffold.data.UserServiceImpl
import com.newler.scaffold.config.modlue.RetrofitProvider

/**
 *
 * @what
 * @author 17173
 * @date 2020/1/10
 *
 */
class DataManager {
    companion object {
        val instance by lazy {
            DataManager()
        }
    }
    private val retrofit = RetrofitProvider.instance.retrofit

    private val userService = UserServiceImpl(retrofit.create(UserApi::class.java))

    fun getUserService()  = userService
}