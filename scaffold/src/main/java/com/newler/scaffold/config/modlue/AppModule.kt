package com.newler.scaffold.config.modlue

import android.app.Application
import android.content.Context
import androidx.annotation.Nullable
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.newler.scaffold.config.AppManager
import com.newler.scaffold.config.MvpScaffoldConfigComponent
import com.newler.state.StateManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 *
 * @what
 * @author 17173
 * @date 2020/1/9
 *
 */
@Module
class AppModule {
    @Singleton
    @Provides
    fun provideGson(@Nullable application: Application, gsonConfiguration: GsonConfiguration?) : Gson{
        val gsonBuilder = GsonBuilder()
        gsonConfiguration?.config(application, gsonBuilder)
        return gsonBuilder.create()
    }

    @Singleton
    @Provides
    fun provideAppManager(application: Application) = AppManager.instance.init(application)

    @Singleton
    @Provides
    fun provideStateManager(stateAdapter: StateManager.Adapter?): StateManager {
        val stateManager = StateManager.instance
        stateAdapter?.let {
            stateManager.initAdapter(it)
        }
        return stateManager
    }

    interface GsonConfiguration {
        fun config(context:Context, gsonBuilder: GsonBuilder)
    }
}