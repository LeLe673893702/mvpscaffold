package com.newler.scaffold.config.modlue

import android.app.Application
import android.content.Context
import androidx.annotation.Nullable
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 *
 * @what
 * @author newler
 * @date 2020/1/8
 *
 */
@Module
class NetWorkModule {
    @Singleton
    @Provides
    fun provideRetrofit(@Nullable application: Application,
                        @Nullable retrofitConfiguration: RetrofitConfiguration?,
                        @Nullable retrofitBuilder: Retrofit.Builder,
                        @Nullable okHttpClient: OkHttpClient,
                        @Nullable baseUrl: HttpUrl,
                        gson: Gson) : Retrofit {

        retrofitBuilder.baseUrl(baseUrl)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
        retrofitConfiguration?.config(application, retrofitBuilder)
        return retrofitBuilder.build()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(@Nullable application: Application,
                            @Nullable okHttpClientConfiguration: OkHttpClientConfiguration?,
                            @Nullable okHttpClientBuilder: OkHttpClient.Builder): OkHttpClient {
        okHttpClientConfiguration?.config(application, okHttpClientBuilder)
        return okHttpClientBuilder.build()
    }

    @Singleton
    @Provides
    fun provideRetrofitBuilder() = Retrofit.Builder()

    @Singleton
    @Provides
    fun provideOkHttpBuilder() = OkHttpClient.Builder()

    interface RetrofitConfiguration {
        fun config(@Nullable context:Context, @Nullable builder:Retrofit.Builder)
    }

    interface OkHttpClientConfiguration{
        fun config(@Nullable context:Context, @Nullable builder: OkHttpClient.Builder)
    }
}