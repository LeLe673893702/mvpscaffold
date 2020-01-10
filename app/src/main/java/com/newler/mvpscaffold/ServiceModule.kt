package com.newler.mvpscaffold

import com.newler.mvpscaffold.data.UserService
import com.newler.mvpscaffold.data.UserServiceImpl
import com.newler.scaffold.config.scope.AppScope
import dagger.Binds
import dagger.Module

/**
 *
 * @what
 * @author 17173
 * @date 2020/1/10
 *
 */
@Module
interface ServiceModule {
    @AppScope
    @Binds
    fun userService(userServiceImpl: UserServiceImpl) : UserService
}