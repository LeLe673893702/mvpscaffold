package com.newler.scaffold.config.modlue

import android.app.Application
import android.content.Context
import androidx.annotation.Nullable
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.newler.scaffold.config.AppManager
import com.newler.scaffold.config.bus.BusStrategy
import com.newler.scaffold.config.bus.ScaffoldBus
import com.newler.state.StateManager
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator

/**
 *
 * @what
 * @author 17173
 * @date 2020/1/9
 *
 */
class AppInitialization {

    fun initStateManager(stateAdapter: StateManager.Adapter?) {
        stateAdapter?.let {
            StateManager.instance.initAdapter(it)
        }
    }

    fun initFooterCreator(defaultRefreshFooterCreator: DefaultRefreshFooterCreator){
        SmartRefreshLayout.setDefaultRefreshFooterCreator(defaultRefreshFooterCreator)
    }

    fun initHeaderCreator(defaultRefreshHeaderCreator: DefaultRefreshHeaderCreator) {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(defaultRefreshHeaderCreator)
    }

    fun initAppManger(application: Application) {
        AppManager.instance.init(application)
    }

    fun initBus(busStrategy: BusStrategy) {
        ScaffoldBus.get().init(busStrategy)
    }
}