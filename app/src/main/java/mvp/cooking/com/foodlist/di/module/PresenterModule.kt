package mvp.cooking.com.foodlist.di.module

import dagger.Module
import dagger.Provides
import mvp.cooking.com.foodlist.data.repository.AppRepository
import mvp.cooking.com.foodlist.view.home.HomeContract
import mvp.cooking.com.foodlist.view.home.HomePresenter

@Module
class PresenterModule {
    @Provides
    fun providesHomePresenter(appRepository: AppRepository): HomeContract.Presenter =
        HomePresenter(appRepository)
}