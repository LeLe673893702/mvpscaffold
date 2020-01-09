package com.newler.mvpscaffold

import android.app.Application
import com.newler.scaffold.config.DaggerMvpScaffoldConfigComponent
import com.newler.scaffold.config.MvpScaffoldConfigComponent
import com.newler.scaffold.config.modlue.GlobalConfigModule
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 *
 * @what
 * @author 17173
 * @date 2020/1/9
 *
 */
class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
            .mvpScaffoldConfigComponent(
                DaggerMvpScaffoldConfigComponent
                    .builder()
                    .application(this)
                    .globalConfigModule(GlobalConfig().applyOptions(this@App, GlobalConfigModule.newBuilder()))
                    .build()
            ).build()
    }
}