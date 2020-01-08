package com.llc.smartterminal.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import com.newler.scaffold.config.BusStrategy
import com.uber.autodispose.AutoDispose
import com.uber.autodispose.AutoDisposeConverter
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider
import javax.inject.Inject


abstract class BaseActivity<P : BasePresenter> : AppCompatActivity() {
    @Inject
    protected var mPresenter:P? = null

    @Inject
    val bus: BusStrategy?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

        initView()

        bus?.register(this)
        
        registerEvent()
        mPresenter?.let {
            it.onStart()
            lifecycle.addObserver(it)
            bus?.register(it)
            
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

    fun attainActivity() = this

    override fun onDestroy() {
        mPresenter?.let {
            lifecycle.removeObserver(it)
            bus?.unregister(it)
        }
        bus?.unregister(this)
        
        unRegisterEvent()
        super.onDestroy()
    }

}