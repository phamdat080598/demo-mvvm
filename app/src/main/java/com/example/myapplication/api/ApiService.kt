package com.example.myapplication.api

import com.example.myapplication.mvvm.model.SubjectsResponse
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("qlsv/get_khungdaotao.php")
    fun getAllSubject(@Field("id") id: String): Observable<SubjectsResponse>
}