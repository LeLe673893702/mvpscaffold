package com.newler.scaffold.base.list

import androidx.recyclerview.widget.RecyclerView
import com.drakeet.multitype.MultiTypeAdapter
import com.newler.scaffold.R
import com.newler.scaffold.base.state.BaseStateActivity
import com.newler.scaffold.base.state.BaseStateFragment
import com.scwang.smartrefresh.layout.SmartRefreshLayout

/**
 *
 * @what
 * @author 17173
 * @date 2020/1/14
 *
 */
abstract class BaseListFragment<P:BaseListPresenter> : BaseStateFragment<P>(), BaseListView {
    protected val refreshLayout:SmartRefreshLayout by lazy {
        view?.findViewById<SmartRefreshLayout>(R.id.smartRefreshLayout)!!
    }

    protected val recyclerView: RecyclerView by lazy {
        view?.findViewById<RecyclerView>(R.id.recycleView)!!
    }

    protected val rvAdapter: MultiTypeAdapter by lazy {
        MultiTypeAdapter()
    }

    override fun initView() {
        initRecycle()
        initRefreshLayout()
    }

    private fun initRecycle() {
        recyclerView.adapter = rvAdapter
        registerAdapter(rvAdapter)
    }

    private fun initRefreshLayout() {
        refreshLayout.setEnableLoadMore(isLoadMoreEnable())
        refreshLayout.setEnableRefresh(isRefreshEnable())
        refreshLayout.setOnRefreshListener {
            mPresenter?.onRefresh()
        }
        refreshLayout.setOnLoadMoreListener {
            mPresenter?.onLoadMore()
        }
    }

    abstract fun registerAdapter(rvAdapter: MultiTypeAdapter)

    override fun refreshList(items: List<Any>) {
        rvAdapter.items = items
        rvAdapter.notifyDataSetChanged()
    }

    override fun loadMoreList(items: List<Any>, start: Int, count: Int) {
        rvAdapter.items = items
        rvAdapter.notifyItemRangeChanged(start, count)
    }

    override fun finishRefreshing(succeed: Boolean) {
        refreshLayout.finishRefresh(succeed)
    }

    override fun finishLoadingMore(succeed: Boolean) {
        refreshLayout.finishLoadMore(succeed)
    }

    override fun setRefreshEnable(enable: Boolean) {
        refreshLayout.setEnableRefresh(enable)
    }

    override fun setLoadMoreEnable(enable: Boolean) {
        refreshLayout.setEnableLoadMore(enable)
    }

    override fun onLoadMoreRest() {
        refreshLayout.setNoMoreData(true)
    }

    override fun isRefreshEnable() = true

    override fun isLoadMoreEnable() = true

    override fun notifyItemChanged(position: Int) {
        rvAdapter.notifyItemChanged(position)
    }

    override fun notifyItemChanged(position: Int, payload: Any?) {
        rvAdapter.notifyItemChanged(position, payload)
    }

    override fun notifyItemRangeChanged(start: Int, count: Int) {
        rvAdapter.notifyItemRangeChanged(start, count)
    }

    override fun notifyItemRangeChanged(start: Int, count: Int, payload: Any?) {
        rvAdapter.notifyItemRangeChanged(start, count, payload)
    }

    override fun notifyItemInserted(position: Int) {
        rvAdapter.notifyItemInserted(position)
    }

    override fun notifyItemRangeInserted(start: Int, count: Int) {
        rvAdapter.notifyItemRangeChanged(start, count)
    }

    override fun notifyItemRemoved(position: Int) {
        rvAdapter.notifyItemRemoved(position)
    }

    override fun notifyItemRangeRemoved(start: Int, count: Int) {
        rvAdapter.notifyItemRangeChanged(start, count)
    }

    override fun notifyDataSetChanged() {
        rvAdapter.notifyDataSetChanged()
    }

    override fun setItems(items: List<Any>) {
        rvAdapter.items = items
    }

    override fun getAdapter() = rvAdapter
}