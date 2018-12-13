package com.mvi.jeanyan.basicres

import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/")
    fun login(@Body json:JsonObject): Observable<String>
}