package mvp.cooking.com.foodlist.di.module

import android.app.Application
import android.arch.persistence.room.Room
import dagger.Module
import dagger.Provides
import mvp.cooking.com.foodlist.data.db.AppDatabase
import mvp.cooking.com.foodlist.data.db.FoodDao
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(application: Application): AppDatabase {
        return Room
            .databaseBuilder(application, AppDatabase::class.java, AppDatabase.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideUserDao(appDataBase: AppDatabase): FoodDao {
        return appDataBase.foodDao()
    }
}