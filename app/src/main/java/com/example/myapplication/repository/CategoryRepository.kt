package com.example.myapplication.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.api.ApiUtils
import com.example.myapplication.mvvm.model.Category
import com.example.myapplication.mvvm.model.CategoryResponse
import com.example.myapplication.mvvm.utils.ShowError
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.withTimeout

class CategoryRepository() {

    private val _category = MutableLiveData<Category>()
    val category : LiveData<Category>
        get() = _category

    suspend fun getCategoryById(id:String, token:String){
        try {
            val api = ApiUtils.getApiService().getCateDetail(id,token)
            when(api.raw().code()){
                200,201 ->  _category.value= api.body()!!.data
            }
//            val result : CategoryResponse =  withTimeout(5000) {
//                ApiUtils.getApiService().getCateDetail(id, token)
//            }
//
        }catch (t:Throwable){
            throw ShowError("không lấy được category",t)
        }
    }

}