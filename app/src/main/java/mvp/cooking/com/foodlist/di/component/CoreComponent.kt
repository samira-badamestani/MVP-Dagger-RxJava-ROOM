package mvp.cooking.com.foodlist.di.component

import android.app.Application

import mvp.cooking.com.foodlist.core.App
import mvp.cooking.com.foodlist.di.module.ActivityBuilder
import mvp.cooking.com.foodlist.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import mvp.cooking.com.foodlist.di.module.DataBaseModule
import mvp.cooking.com.foodlist.di.module.PresenterModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, NetworkModule::class,  ActivityBuilder::class,
    PresenterModule::class, DataBaseModule::class])
interface CoreComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): CoreComponent
    }


}