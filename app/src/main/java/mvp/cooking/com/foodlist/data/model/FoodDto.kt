package mvp.cooking.com.foodlist.data.model

import com.google.gson.annotations.SerializedName

data class FoodDto(
    @SerializedName("results") val results: MutableList<Food>
)