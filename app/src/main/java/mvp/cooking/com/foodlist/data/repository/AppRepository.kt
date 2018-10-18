package mvp.cooking.com.foodlist.data.repository

import io.reactivex.disposables.Disposable
import mvp.cooking.com.foodlist.data.model.Food
import mvp.cooking.com.foodlist.data.model.FoodDto
import mvp.cooking.com.foodlist.data.network.ApiError
import io.reactivex.Observable

interface AppRepository {

    fun getFoods(
        success: (FoodDto) -> Unit,
        failure: (ApiError) -> Unit = {},
        terminate: () -> Unit = {}
    ): Disposable

    fun insertFood(food: Food): Disposable
}