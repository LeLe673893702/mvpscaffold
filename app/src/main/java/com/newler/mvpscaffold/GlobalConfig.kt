package com.newler.mvpscaffold

import android.app.Application
import android.content.Context
import android.view.View
import android.widget.TextView
import com.google.gson.GsonBuilder
import com.newler.scaffold.config.ScaffoldConfig
import com.newler.scaffold.config.bus.RxBusStrategy
import com.newler.scaffold.config.modlue.AppInitialization
import com.newler.scaffold.config.modlue.GlobalConfigModule
import com.newler.scaffold.config.modlue.NetWorkModule
import com.newler.state.StateManager
import com.newler.state.StateView
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 *
 * @what
 * @author 17173
 * @date 2020/1/9
 *
 */
class GlobalConfig : ScaffoldConfig {
    override fun applyOptions(
        application: Application,
        builder: GlobalConfigModule.Builder
    ): GlobalConfigModule {
       return builder
           .application(application)
            .gson(object : NetWorkModule.GsonConfiguration {
                override fun config(context: Context, gsonBuilder: GsonBuilder) {
                    gsonBuilder.serializeNulls().enableComplexMapKeySerialization()
                }
            })
            .baseUrl("http://ark.dev.17173.com/api/v1/")
            .okHttpClient(object : NetWorkModule.OkHttpClientConfiguration {
                override fun config(context: Context, builder: OkHttpClient.Builder) {
                    builder.connectTimeout(5, TimeUnit.SECONDS)
                        .writeTimeout(3, TimeUnit.MINUTES)
                        .readTimeout(3, TimeUnit.MINUTES)
                        .retryOnConnectionFailure(true)
                }
            })
           .bus(RxBusStrategy())
           .stateViewAdapter(StateManagerAdapter(application))
           .builder()
    }

    class StateManagerAdapter(private val context: Context) : StateManager.Adapter {
        override fun getView(holder: com.newler.state.StateManager.Holder, viewState: Int): StateView {
            return object : StateView {
                override fun getView(): View {
                    return TextView(context)
                }

                override fun showState(state: Int) {
                }

            }
        }

    }
}