package mvp.cooking.com.foodlist.view.home

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_home.*
import mvp.cooking.com.foodlist.R
import mvp.cooking.com.foodlist.data.model.FoodDto
import mvp.cooking.com.foodlist.data.network.ApiError
import javax.inject.Inject

class  HomeFragment: DaggerFragment(),HomeContract.View {

    private val TAG: String = HomeFragment::class.java.simpleName

    companion object {
        val FRAGMENT_NAME: String = HomeFragment::class.java.name
    }
    @Inject
    lateinit var presenter: HomeContract.Presenter
    val adapter : HomeAdapter by lazy { HomeAdapter(arrayListOf()) }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        presenter.getFoods()
    }

    override fun showWait() {
        Log.e(TAG,"showWait")
        progressBar_home.visibility=View.VISIBLE
    }

    override fun removeWait() {
        Log.e(TAG,"removeWait")
        progressBar_home.visibility=View.GONE
    }

    override fun showFoods(foodDto: FoodDto) {
        Log.e(TAG,"showFoods")
        rv_main_home.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_main_home.adapter = adapter
        if (foodDto.results.isNotEmpty()) {
            adapter.clear()
            adapter.add(foodDto.results)

        }else{
            Toast.makeText(context, context?.getString(R.string.empty_list), android.widget.Toast.LENGTH_LONG).show()
        }
    }

    override fun onFailure(apiError: ApiError) {
        Log.e(TAG,"onFailure")
        progressBar_home.visibility=View.GONE
        Toast.makeText(context,apiError.getErrorMessage(),Toast.LENGTH_LONG).show()
    }
    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView(this)
        presenter.destroy()
    }

}