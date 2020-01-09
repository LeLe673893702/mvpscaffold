package com.newler.scaffold.config

import com.hwangjr.rxbus.RxBus
import dagger.Module

/**
 *
 * @what 全局配置管理器
 * @author 17173
 * @date 2020/1/8
 *
 */
@Module
class GlobalConfigModule {
    private var busStrategy : BusStrategy ?= null
    private var retrofit :NetModule.RetrofitConfiguration ?= null
}