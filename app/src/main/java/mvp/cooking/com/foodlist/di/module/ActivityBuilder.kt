package mvp.cooking.com.foodlist.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import mvp.cooking.com.foodlist.view.MainActivity

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityProviders::class])
    abstract fun bindMainActivity(): MainActivity
}