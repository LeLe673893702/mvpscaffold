package com.newler.mvpscaffold.register

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
abstract class RegisterModule {
    @Binds
    @ActivityScope
    abstract fun providePresenter(presenter: RegisterPresenter):RegisterContract.Presenter

    @Binds
    @ActivityScope
    abstract fun provideView(view: RegisterActivity) : RegisterContract.View

    @ContributesAndroidInjector
    abstract fun inject() : RegisterActivity
}