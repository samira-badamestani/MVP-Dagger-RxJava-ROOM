package mvp.cooking.com.foodlist.view.home

import mvp.cooking.com.foodlist.data.model.FoodDto
import mvp.cooking.com.foodlist.data.network.ApiError
import mvp.cooking.com.foodlist.view.base.BasePresenter
import mvp.cooking.com.foodlist.view.base.BaseView

interface HomeContract {
    interface View : BaseView {
        fun showWait()
        fun removeWait()
        fun showFoods(foodDto: FoodDto)
        fun onFailure(apiError: ApiError)
    }

    interface Presenter : BasePresenter<View> {
          fun getFoods()
    }
}