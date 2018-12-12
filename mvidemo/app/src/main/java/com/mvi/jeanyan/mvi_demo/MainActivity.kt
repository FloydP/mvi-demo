package com.mvi.jeanyan.mvi_demo

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.jakewharton.rxbinding3.view.clicks
import com.mvi.jeanyan.mvilib.base.MviActivity
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MviActivity<TestView, TestPresenter>(), TestView {
    override fun getWeather(): Observable<Unit> {
        return bt.clicks()
    }

    override fun renderToUI(state: TestState) {
        when (state) {
            is TestState.LodingState -> {
                Log.d("TAG", "showLoadingState")
            }
            is TestState.DataState -> {
                Toast.makeText(this, "data", Toast.LENGTH_SHORT).show()
            }
            is TestState.Error -> {
                Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getMviView(): TestView {
        return this
    }

    override fun createPresenter(): TestPresenter {
        return TestPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
