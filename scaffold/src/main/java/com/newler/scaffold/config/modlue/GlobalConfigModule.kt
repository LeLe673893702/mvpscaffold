package com.newler.scaffold.config.modlue

import android.widget.TextView
import androidx.annotation.Nullable
import com.newler.scaffold.config.bus.BusStrategy
import com.newler.scaffold.config.bus.RxBusStrategy
import com.newler.state.StateManager
import com.newler.state.StateView
import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import javax.inject.Singleton

/**
 *
 * @what 全局配置管理器
 * @author 17173
 * @date 2020/1/8
 *
 */
@Module
class GlobalConfigModule private constructor(builder: Builder) {
    private var busStrategy : BusStrategy?= null
    private var retrofitConfiguration : NetWorkModule.RetrofitConfiguration ?= null
    private var okHttpConfiguration: NetWorkModule.OkHttpClientConfiguration ?= null
    private var gsonConfiguration: AppModule.GsonConfiguration ?= null
    private var stateAdapter: StateManager.Adapter ?= null
    private var baseUrl: HttpUrl ?= null
    companion object{
        fun newBuilder()  = Builder()
    }
    init {
        this.busStrategy =
            builder.busStrategy
        this.retrofitConfiguration =
            builder.retrofitConfiguration
        this.okHttpConfiguration =
            builder.okHttpConfiguration
        this.gsonConfiguration =
            builder.gsonConfiguration
        this.stateAdapter =
            builder.stateViewAdapter
        this.baseUrl =
            builder.baseUrl
    }

    @Singleton
    @Provides
    @Nullable
    fun provideBusStrategy() : BusStrategy? {
        return busStrategy
    }

    @Singleton
    @Provides
    @Nullable
    fun provideRetrofitConfiguration() : NetWorkModule.RetrofitConfiguration? {
        return retrofitConfiguration
    }

    @Singleton
    @Provides
    fun provideOkHttpClientConfiguration() : NetWorkModule.OkHttpClientConfiguration? {
        return okHttpConfiguration
    }

    @Singleton
    @Provides
    @Nullable
    fun provideGsonConfiguration() : AppModule.GsonConfiguration? {
        return gsonConfiguration
    }

    @Singleton
    @Provides
    @Nullable
    fun provideStateViewAdapter() : StateManager.Adapter? {
        return object : StateManager.Adapter {
            override fun getView(holder: StateManager.Holder, viewState: Int): StateView {
                return null!!
            }

        }
    }

    @Singleton
    @Provides
    @Nullable
    fun provideBaseUrl() : HttpUrl? {
        return baseUrl
    }

    class Builder {
        internal var busStrategy : BusStrategy?= null
        internal var retrofitConfiguration : NetWorkModule.RetrofitConfiguration ?= null
        internal var okHttpConfiguration: NetWorkModule.OkHttpClientConfiguration ?= null
        internal var gsonConfiguration: AppModule.GsonConfiguration?= null
        internal var stateViewAdapter: StateManager.Adapter ?= null
        internal var baseUrl: HttpUrl ?= null

        fun bus(busStrategy: BusStrategy) : Builder {
            this.busStrategy = busStrategy
            return this
        }

        fun retrofit(retrofitConfiguration : NetWorkModule.RetrofitConfiguration) : Builder {
            this.retrofitConfiguration = retrofitConfiguration
            return this
        }

        fun okHttpClient(okHttpConfiguration: NetWorkModule.OkHttpClientConfiguration) : Builder {
            this.okHttpConfiguration = okHttpConfiguration
            return this
        }

        fun gson(gsonConfiguration: AppModule.GsonConfiguration) : Builder {
            this.gsonConfiguration = gsonConfiguration
            return this
        }

        fun stateViewAdapter(stateViewAdapter: StateManager.Adapter) : Builder {
            this.stateViewAdapter = stateViewAdapter
            return this
        }

        fun baseUrl(baseUrl: String) : Builder {
            this.baseUrl = HttpUrl.parse(baseUrl)
            return this
        }


        fun builder(): GlobalConfigModule {
            if (busStrategy == null) busStrategy = RxBusStrategy()
            return GlobalConfigModule(this)
        }

    }
}