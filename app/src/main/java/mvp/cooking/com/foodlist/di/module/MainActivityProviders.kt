package mvp.cooking.com.foodlist.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import mvp.cooking.com.foodlist.view.home.HomeFragment

@Module
abstract class MainActivityProviders{
    @ContributesAndroidInjector
    abstract fun provideHomeFragment(): HomeFragment

}