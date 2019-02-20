package com.android.testtranstisitions.ui.modules.main.home

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomePresenter @Inject
constructor() {
    val LIMIT:Int = 12

    var mView: HomeView? = null
    var offset:Int = 0
    var last: Int? = null

    fun getInitList() {
        mView?.loadData(mutableListOf(1, 2, 3,4,5,6,7))
    }

}
