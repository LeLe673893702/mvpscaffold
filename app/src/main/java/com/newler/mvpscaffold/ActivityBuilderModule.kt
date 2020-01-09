package com.newler.mvpscaffold

import com.newler.mvpscaffold.register.RegisterActivity
import com.newler.mvpscaffold.register.RegisterModule
import com.newler.scaffold.config.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 *
 * @what
 * @author newler
 * @date 2020/1/10
 *
 */
@Module
interface ActivityBuilderModule {
    @ContributesAndroidInjector(modules = [RegisterModule::class])
     fun inject() : RegisterActivity
}
