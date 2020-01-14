package com.newler.mvpscaffold.data

import io.reactivex.Observable

/**
 *
 * @what
 * @author 17173
 * @date 2020/1/9
 *
 */
class UserServiceImpl(private val userApi: UserApi) : UserService {

    override fun register(
        username: String,
        email: String,
        password_confirmation: String,
        password: String
    ): Observable<String> {
        return userApi.register(User(username, email, password_confirmation, password))
    }

}