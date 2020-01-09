package com.newler.mvpscaffold.data

import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject

/**
 *
 * @what
 * @author 17173
 * @date 2020/1/9
 *
 */
class UserServiceImpl @Inject constructor() : UserService {
    @Inject
    lateinit var retrofit: Retrofit
    private val userApi by lazy {
        retrofit.create(UserService::class.java)
    }
    override fun register(
        username: String,
        email: String,
        password_confirmation: String,
        password: String
    ): Observable<String> {
        return userApi.register(username, email, password_confirmation, password)
    }

}