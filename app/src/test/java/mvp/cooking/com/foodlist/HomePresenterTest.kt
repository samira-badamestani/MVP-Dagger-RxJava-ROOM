package mvp.cooking.com.foodlist


import mvp.cooking.com.foodlist.data.repository.AppRepository
import mvp.cooking.com.foodlist.view.home.HomeContract
import mvp.cooking.com.foodlist.view.home.HomePresenter
import com.nhaarman.mockito_kotlin.mock
import org.junit.After
import org.junit.Before
import org.junit.Test


class HomePresenterTest {

    lateinit var presenter: HomePresenter
    lateinit var view: HomeContract.View
    lateinit var appRepository: AppRepository

    @Before
    fun setup() {
        view = mock()
        appRepository = mock()
        presenter = HomePresenter(appRepository)
        presenter.attachView(view)
    }

    @After
    fun dispose() {
        presenter.detachView(view)
    }


    @Test
    fun `should alert unknown error to view when fetching foods`() {

    }

    @Test
    fun `should show food list when fetching home`() {

    }
}


