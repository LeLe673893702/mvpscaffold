package com.newler.mvpscaffold

import com.newler.scaffold.config.MvpScaffoldConfigComponent
import com.newler.scaffold.config.scope.AppScope
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule


/**
 *
 * @what
 * @author 17173
 * @date 2020/1/9
 *
 */
@AppScope
@Component(modules = [AndroidSupportInjectionModule::class, ActivityBuilderModule::class, ServiceModule::class],
    dependencies = [MvpScaffoldConfigComponent::class])
interface AppComponent : AndroidInjector<App>  {
}