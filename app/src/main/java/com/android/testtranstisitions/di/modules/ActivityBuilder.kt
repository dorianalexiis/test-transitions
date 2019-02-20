package com.android.testtranstisitions.di.modules

import com.android.testtranstisitions.di.modules.fragments.MainFragmentProvider
import com.android.testtranstisitions.ui.modules.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder{

    @ContributesAndroidInjector(modules = [BaseActivityModule::class, MainFragmentProvider::class])
    abstract fun bindMainActivity(): MainActivity

}