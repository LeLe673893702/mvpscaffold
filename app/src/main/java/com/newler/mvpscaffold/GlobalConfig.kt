package com.newler.mvpscaffold

import android.app.Application
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.gson.GsonBuilder
import com.newler.scaffold.config.ScaffoldConfig
import com.newler.scaffold.config.bus.RxBusStrategy
import com.newler.scaffold.config.modlue.AppInitialization
import com.newler.scaffold.config.modlue.GlobalConfigModule
import com.newler.scaffold.config.modlue.NetWorkModule
import com.newler.scaffold.utils.ResourcesUtil
import com.newler.state.StateManager
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
        override fun getView(holder: StateManager.Holder, viewState: Int): View {
            val globalStatusView =  GlobalStatusView(holder.getContext(), viewState, holder)
            val layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT)
            globalStatusView.layoutParams = layoutParams
            ResourcesUtil.getColor(R.color.colorAccent)?.let {
                globalStatusView.setBackgroundColor(it)
            }
            return globalStatusView
        }

    }
}