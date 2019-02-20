package com.android.testtranstisitions.ui.modules.main.home

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.android.dars.base.BaseInjectFragment
import com.android.testtranstisitions.R
import com.android.testtranstisitions.ui.adapters.HomeAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment:BaseInjectFragment(), HomeView{

    @Inject
    @JvmField
    var homePresenter: HomePresenter?  = null

    private lateinit var adapter: HomeAdapter

    companion object {
        @JvmStatic fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun initialize() {
        super.initialize()
        homePresenter?.let {
            it.mView = this@HomeFragment
        }
    }

    override fun getFragmentLayoutResId():Int = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pgLoading.visibility = View.VISIBLE
        homePresenter?.getInitList()
    }

    override fun loadData(list: MutableList<Int>) {
        adapter = HomeAdapter(list)
        val linearLayout = LinearLayoutManager(context)
        rcHome.layoutManager = linearLayout
        rcHome.adapter = adapter
        pgLoading.visibility = View.GONE
    }
}