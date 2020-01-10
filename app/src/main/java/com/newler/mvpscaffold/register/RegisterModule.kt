package com.newler.mvpscaffold.register

import com.newler.scaffold.base.BasePresenter
import com.newler.scaffold.config.MvpScaffoldConfigComponent
import com.newler.scaffold.config.scope.ActivityScope
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 *
 * @what
 * @author 17173
 * @date 2020/1/9
 *
 */
@Module
interface RegisterModule {
    @Binds
    @ActivityScope
    fun providePresenter(presenter: RegisterPresenter):RegisterContract.Presenter

    @Binds
    @ActivityScope
    fun provideView(view: RegisterActivity) : RegisterContract.View
}