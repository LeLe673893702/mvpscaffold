package com.newler.scaffold.config.bus

import com.hwangjr.rxbus.Bus
import com.hwangjr.rxbus.RxBus

/**
 *
 * @what
 * @author 17173
 * @date 2020/1/13
 *
 */
class ScaffoldBus {
    companion object {
        val bus: Bus by lazy {
            Bus()
        }
        fun get():Bus {
            return bus
        }
    }
}