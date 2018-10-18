package mvp.cooking.com.foodlist.view.home

import android.util.Log
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import mvp.cooking.com.foodlist.data.model.Food
import mvp.cooking.com.foodlist.data.repository.AppRepository


class HomePresenter (private val appRepository: AppRepository): HomeContract.Presenter{
    private val compositeDisposable = CompositeDisposable()
    var view: HomeContract.View? = null
    private val TAG: String = HomePresenter::class.java.simpleName


    override fun getFoods() {
        appRepository.getFoods(

            {
                Log.d(TAG, "getFoods.success() called with: $it")
               view?.removeWait()
                view?.showFoods(it)
                if (it.results.size>0){
                    insertToDb(it.results)
                }
            },
            {
                Log.d(TAG, "getFoods.error() called with: $it")
             view?.removeWait()
                view?.onFailure(it)
            },
            {
                view?.removeWait()
            }
        ).also {
            if (it !=null)
            compositeDisposable.add(it)
        }
    }

    private fun insertToDb(results: MutableList<Food>) {
        for (food in results){
            Log.d(TAG,"${food.title} inserted to databade")
            appRepository.insertFood(food).also { compositeDisposable.add(it) }
        }
    }

    override fun detachView(view: HomeContract.View) {
        this.view = null
    }

    override fun attachView(view: HomeContract.View) {
        this.view = view
    }

    override fun destroy() {
        compositeDisposable.clear()
    }

}