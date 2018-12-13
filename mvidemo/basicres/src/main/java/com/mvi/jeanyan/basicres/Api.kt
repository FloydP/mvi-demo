package com.mvi.jeanyan.basicres

import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Api private constructor() {

    private val retrofit: Retrofit
    private val apiServic: ApiService

    init {
        retrofit = Retrofit.Builder().baseUrl("")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiServic = retrofit.create(ApiService::class.java)
    }

    companion object {
        var instance: Api? = null
            get() {
                if (field == null)
                    field = internal()
                return field
            }
        @Synchronized
        private fun internal(): Api {
            return Api()
        }
    }

    fun login(studioId:String): Observable<String> {
        val json = JsonObject()
        json.addProperty("studioId",studioId)
        return apiServic.login(json)
    }
}