package com.newler.scaffold.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import com.newler.scaffold.config.bus.BusStrategy
import com.uber.autodispose.AutoDispose
import com.uber.autodispose.AutoDisposeConverter
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider
import javax.inject.Inject

abstract class BaseFragment<T : BasePresenter> : Fragment() {
    @Inject
    @JvmField
    var mPresenter:T? = null
    @Inject
    @JvmField
    var bus: BusStrategy?= null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        if (useRxBus()) {
            bus?.register(this)
        }

        registerEvent()
        mPresenter?.let {
            it.onStart()
            lifecycle.addObserver(it)
            if (useRxBus()) {
                bus?.register(it)
            }
        }
    }

    abstract fun initView()

    abstract fun registerEvent()

    abstract fun unRegisterEvent()

    @LayoutRes
    @Nullable
    abstract fun getLayoutId(): Int

    fun <T> autoDispose(): AutoDisposeConverter<T> {
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(this))
    }

    fun <T> disposeOnDestroy(): AutoDisposeConverter<T> {
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(this, Lifecycle.Event.ON_DESTROY))
    }

    fun attainActivity():FragmentActivity? {
        return  activity
    }

    fun useRxBus() = true

    override fun onDestroyView() {
        mPresenter?.let {
            lifecycle.removeObserver(it)
            if (useRxBus()) {
                bus?.unregister(it)
            }
        }
        if (useRxBus()) {
            bus?.unregister(this)
        }
        unRegisterEvent()
        super.onDestroyView()
    }
}