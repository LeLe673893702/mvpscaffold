package com.newler.mvpscaffold.vp;

import com.newler.scaffold.base.BasePresenter
import com.newler.scaffold.base.BaseView
import com.newler.scaffold.base.list.BaseListPresenter
import com.newler.scaffold.base.list.BaseListView
import com.newler.scaffold.base.state.BaseStatePresenter
import com.newler.scaffold.base.state.BaseStateView

/**
 * Title:
 * Description:
 * Copyright © 2001-2020 17173. All rights reserved.
 *
 * @author
 * @version 2020-03-25
 */
interface TestStateContract {

    interface View : BaseStateView {

    }

    interface Presenter : BaseStatePresenter {

    }
}