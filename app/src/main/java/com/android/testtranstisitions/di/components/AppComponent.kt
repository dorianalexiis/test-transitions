package com.android.testtranstisitions.di.components

import com.android.testtranstisitions.di.modules.ActivityBuilder
import com.android.testtranstisitions.di.modules.AppModule
import com.android.testtranstisitions.ui.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class])
interface AppComponent {


    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent

    }

    fun inject(app: App)

}
