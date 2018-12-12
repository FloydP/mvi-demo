package com.mvi.jeanyan.mvi_demo

import android.util.AndroidException
import android.util.Log
import com.mvi.jeanyan.mvilib.base.MviBasePresenter
import com.mvi.jeanyan.mvilib.base.MviView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface TestView : MviView {
    fun getWeather(): Observable<Unit>
    fun renderToUI(state: TestState)
}

class TestPresenter : MviBasePresenter<TestView, TestState>() {

    override fun bindIntents() {
        Log.d("TAG","bindIntents")
        val getWeatherInfo = intent(TestView::getWeather)
            .switchMap { TestData.getData() }
            .observeOn(AndroidSchedulers.mainThread())

        subscribeViewState(getWeatherInfo,TestView::renderToUI)
    }
}

sealed class TestState {
    object LodingState : TestState()
    data class DataState(val data: String) : TestState()
    data class Error(val error: Throwable) : TestState()
}

object TestData {
    fun getData(): Observable<TestState> {
        return TestRepository.loadWeatherInfoJson()
            .map<TestState> { TestState.DataState(it) }
            .startWith(TestState.LodingState)
            .onErrorReturn { TestState.Error(it) }
    }
}


object TestRepository {

    fun loadWeatherInfoJson(): Observable<String> {
        Log.d("TAG","loadWeatherInfoJson")
        return Observable.create {
            it.onNext("Hello World")
        }
    }
}
