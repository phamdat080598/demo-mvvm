package com.example.myapplication.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.api.ApiUtils
import com.example.myapplication.mvvm.model.Category
import com.example.myapplication.mvvm.model.CategoryResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CategoryRepository() {

    private val composite=CompositeDisposable()

    private val _category = MutableLiveData<Category>()
    val category : LiveData<Category>
        get() = _category

    private val _messageResponse = MutableLiveData<String>()
    val messageResponse : LiveData<String>
        get() = _messageResponse

    fun getCategoryById(id:String,token:String){
        composite.add(ApiUtils.getApiService().getCateDetail(id,token)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::onGetCategoryByIdSucess){
                t -> onGetCategoryByIdFail("Không lấy được category",t)
            }
        )
    }

    private fun onGetCategoryByIdSucess(response: CategoryResponse){
        if(response.success==1){
            _category.value = response.data
            Log.d("onGetCategoryByIdSucess",response.success.toString())
        }
    }

    private fun onGetCategoryByIdFail(error:String,t:Throwable){
        _messageResponse.value = error
        Log.d("onGetCategoryByIdFail",t.localizedMessage)
    }

    fun dispose(){
        composite.dispose()
    }
}