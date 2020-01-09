package com.newler.mvpscaffold

import android.app.Application
import com.google.gson.Gson
import com.newler.mvpscaffold.register.RegisterModule
import com.newler.scaffold.config.MvpScaffoldConfigComponent
import com.newler.scaffold.config.modlue.AppModule
import com.newler.scaffold.config.modlue.GlobalConfigModule
import com.newler.scaffold.config.modlue.NetWorkModule
import com.newler.scaffold.config.scope.AppScope
import com.newler.state.StateManager
import dagger.BindsInstance
import dagger.Component
import dagger.Provides
import dagger.Subcomponent
import dagger.android.AndroidInjector
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton


/**
 *
 * @what
 * @author 17173
 * @date 2020/1/9
 *
 */
@AppScope
@Component(modules = [RegisterModule::class], dependencies = [MvpScaffoldConfigComponent::class])
interface AppComponent : AndroidInjector<App>  {

    @Component.Builder
    interface Builder : AndroidInjector.Factory<App> {
       fun mvpScaffoldConfigComponent(mvpScaffoldConfigComponent: MvpScaffoldConfigComponent):Builder
        fun build() : AppComponent
    }
}