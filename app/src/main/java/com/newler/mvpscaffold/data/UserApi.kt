package com.newler.mvpscaffold.data

import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

/**
 *
 * @what
 * @author 17173
 * @date 2020/1/8
 *
 */
interface UserApi {
    @FormUrlEncoded
    @POST("/auth/identity/register")
    fun register(
        @Field("username") username:String,
        @Field("email") email:String,
        @Field("password_confirmation") password_confirmation:String,
        @Field("password") password: String
    ): Observable<String>

    @FormUrlEncoded
    @POST("/auth/identity/login")
    fun login(
        @Field("username") username:String,
        @Field("email") email:String
    )
}