package com.newler.mvpscaffold

import android.app.Application
import android.util.Log
import com.newler.scaffold.config.modlue.GlobalConfigModule

/**
 *
 * @what
 * @author 17173
 * @date 2020/1/9
 *
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.e("APPPPPP", "oncreate")
        GlobalConfig()
            .applyOptions(this, GlobalConfigModule.newBuilder())
            .init()
    }
}