package com.newler.mvpscaffold.data

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *
 * @what
 * @author 17173
 * @date 2020/1/8
 *
 */

data class LoginUser(
    var token: String,
    val user: User
)

@SuppressLint("ParcelCreator")
@Parcelize
data class User(
    var username:String,
    var email:String,
    var password_confirmation:String,
    var password:String
) : Parcelable