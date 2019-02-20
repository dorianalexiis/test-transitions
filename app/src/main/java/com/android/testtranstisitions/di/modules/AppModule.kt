package com.android.testtranstisitions.di.modules

import android.content.Context
import com.android.testtranstisitions.ui.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideContext(app: App): Context = app
}