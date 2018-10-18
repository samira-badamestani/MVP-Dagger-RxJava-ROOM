package mvp.cooking.com.foodlist.data.network

import io.reactivex.Observable
import mvp.cooking.com.foodlist.data.model.FoodDto
import retrofit2.http.GET

interface ApiService {

    @GET("api/")
    fun getHome(
    ): Observable<FoodDto>


}