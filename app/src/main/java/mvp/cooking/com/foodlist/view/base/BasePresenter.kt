package mvp.cooking.com.foodlist.view.base

interface BasePresenter<in V : BaseView> {
    fun detachView(view: V)
    fun attachView(view: V)
    fun destroy()
}