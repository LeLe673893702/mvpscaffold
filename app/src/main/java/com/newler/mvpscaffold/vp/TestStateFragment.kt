package com.newler.mvpscaffold.vp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.newler.mvpscaffold.R
import com.newler.scaffold.base.state.BaseStateFragment
import com.newler.state.StateManager

import kotlinx.android.synthetic.main.fragment_state.view.*

/**
 * A simple [Fragment] subclass.
 */
class TestStateFragment : BaseStateFragment<TestStateContract.Presenter>(), TestStateContract.View {
   override val holder by lazy {
        view?.let {
            StateManager.instance.wrap(it.tvState)
        }
    }
    companion object {
        fun newInstance() : TestStateFragment = TestStateFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_state, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        holder?.showLoadFailed()
        holder?.showContent()
    }

    override fun initView() {
    }

    override fun registerEvent() {
    }

    override fun unregisterEvent() {
    }

    override fun getLayoutId(): Int = R.layout.fragment_state

    override fun getPresenter(): TestStateContract.Presenter = TestStatePresenter(this)

}
