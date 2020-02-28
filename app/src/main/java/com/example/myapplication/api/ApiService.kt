package com.example.myapplication.api

import com.example.myapplication.mvvm.model.CategoryResponse
import io.reactivex.Observable
import retrofit2.http.*

interface ApiService {
    @GET("api/category/{id}")
    fun getCateDetail(@Path("id") id: String, @Header("Authorization") Authorization: String)
            : Observable<CategoryResponse>
}