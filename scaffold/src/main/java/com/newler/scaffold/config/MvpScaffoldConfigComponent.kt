package com.newler.scaffold.config

import android.app.Application
import com.google.gson.Gson
import com.newler.scaffold.config.modlue.AppModule
import com.newler.scaffold.config.modlue.GlobalConfigModule
import com.newler.scaffold.config.modlue.NetWorkModule
import com.newler.scaffold.config.scope.ActivityScope
import com.newler.state.StateManager
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
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
@Singleton
@Component(modules = [AppModule::class, NetWorkModule::class, GlobalConfigModule::class])
interface MvpScaffoldConfigComponent {
    fun okHttpClient(): OkHttpClient?

    fun gson(): Gson?

    fun retrofit() : Retrofit?

    fun stateManager() : StateManager?

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun globalConfigModule(globalConfigModule: GlobalConfigModule) : Builder

        fun build() : MvpScaffoldConfigComponent
    }
}