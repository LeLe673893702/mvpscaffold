package com.newler.mvpscaffold.vp;


/**
 * Title:
 * Description:
 * Copyright © 2001-2020 17173. All rights reserved.
 *
 * @author
 * @version 2020-03-25
 */
internal class TestStatePresenter(
    private val mView: TestStateContract.View):
    TestStateContract.Presenter {
//
//    private val pageLoad by lazy {
//        PageDropUpLoader<ReactionUserVm>(mView)
//    }

//    private val pageInfo by lazy {
//        pageLoad.getPageInfo()
//    }

    /**
     * 初始化
     */
    override fun onStart() {
    }

    /**
     * 加载数据
     */
//    override fun onLoadData() {
//        mView.showLoading()
//
//        mService.getReactionUsersByEmojiId(messageId, emojiId, PageConstants.limit)
//            .compose(RxUtil.applySchedulers())
//            .`as`(mView.disposeOnDestroy())
//            .subscribe({
//                pageLoad.onLoadSucceed(it)
//            }, {
//                ErrorHandler.onError(it)
//                mView.showLoadFailed()
//            })
//    }

    /**
     * 重新加载
     */
//    override fun onRetry() {
//        onLoadData()
//    }

    /**
     * 刷新数据
     */
//    override fun onRefresh() {
//        mService.getReactionUsersByEmojiId(messageId, emojiId, PageConstants.limit)
//            .compose(RxUtil.applySchedulers())
//            .`as`(mView.disposeOnDestroy())
//            .subscribe({
//                pageLoad.onLoadSucceed(it)
//            }, {
//                ErrorHandler.onError(it)
//                mView.showLoadFailed()
//            })
//    }

    /**
     * 加载更多数据
     */
//    override fun onLoadMore() {
//        mService.getReactionUsersByEmojiId(messageId, emojiId, PageConstants.limit, after = pageInfo.after)
//            .compose(RxUtil.applySchedulers())
//            .`as`(mView.disposeOnDestroy())
//            .subscribe({
//                pageLoad.onLoadSucceed(it)
//            }, {
//                ErrorHandler.onError(it)
//            })
//    }

    /**
     * 清理工作
     */
    override fun onDestroy() {

    }

    override fun onLoadData() {
    }

    override fun onRetry() {
    }
}
