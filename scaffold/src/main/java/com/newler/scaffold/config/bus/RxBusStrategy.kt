package com.newler.scaffold.config.bus

import com.hwangjr.rxbus.RxBus
import com.newler.scaffold.config.bus.BusStrategy

/**
 *
 * @what
 * @author 17173
 * @date 2020/1/9
 *
 */
class RxBusStrategy : BusStrategy {
    override fun register(obj: Any) {
        RxBus.get().register(obj)
    }

    override fun unregister(obj: Any) {
        RxBus.get().register(obj)
    }
}