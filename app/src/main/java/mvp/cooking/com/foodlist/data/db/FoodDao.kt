package mvp.cooking.com.foodlist.data.db

import android.arch.persistence.room.*
import mvp.cooking.com.foodlist.data.model.Food

@Dao
interface FoodDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFood(food: Food): Long

    @Delete
    fun deleteFood(food: Food): Int

    @Query("SELECT * from Food")
    fun selectAllFoods(): MutableList<Food>

}