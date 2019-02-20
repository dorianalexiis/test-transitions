package com.android.testtranstisitions.di.modules.fragments


import com.android.testtranstisitions.ui.modules.main.home.HomeFragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentProvider {

    @ContributesAndroidInjector(modules = arrayOf(BaseFragmentModule::class))
    internal abstract fun provideHomeFragmentFactory(): HomeFragment

}
