package com.android.testtranstisitions.ui

import com.android.dars.base.BaseInjectApp
import com.android.testtranstisitions.di.components.DaggerAppComponent
import com.android.testtranstisitions.utils.Session



class App: BaseInjectApp() {

    override fun onCreate() {
        super.onCreate()
        Session.init(this)
        initializeInjector()
    }

    private fun initializeInjector(){
        val component = DaggerAppComponent
                .builder()
                .application(this)
                .build()
        component.inject(this)
    }

}