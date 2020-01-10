package com.newler.mvpscaffold.data

import io.reactivex.Observable
import retrofit2.http.*

/**
 *
 * @what
 * @author 17173
 * @date 2020/1/8
 *
 */
interface UserApi {
    @Headers("Content-Type:application/json")
    @POST("auth/identity/register")
    fun register(
        @Body user:User
    ): Observable<String>

    @FormUrlEncoded
    @POST("auth/identity/login")
    fun login(
        @Field("username") username:String,
        @Field("email") email:String
    )
}