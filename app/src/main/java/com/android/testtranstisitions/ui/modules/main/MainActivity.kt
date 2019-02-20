package com.android.testtranstisitions.ui.modules.main

import android.os.Bundle
import com.android.dars.base.BaseInjectActivity
import com.android.testtranstisitions.ui.modules.main.home.HomeFragment

class MainActivity : BaseInjectActivity() {

    override fun onViewCreated(savedInstanceState: Bundle?) {
        super.onViewCreated(savedInstanceState)
        if (savedInstanceState == null){
            replaceFragment(HomeFragment.newInstance())
        }
    }

}
