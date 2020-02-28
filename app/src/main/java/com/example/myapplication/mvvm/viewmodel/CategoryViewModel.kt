package com.example.myapplication.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.mvvm.model.Category
import com.example.myapplication.repository.CategoryRepository
import io.reactivex.disposables.CompositeDisposable

class CategoryViewModel : ViewModel() {

    private val composite = CompositeDisposable()
    private val repository = CategoryRepository(composite) // chỗ này phải xem lại

    val category : LiveData<Category> by lazy {
        repository.category
    }
    val messageResponse : LiveData<String> by lazy {
        repository.messageResponse
    }

    fun getCategoryById(id:String,token:String){
        repository.getCategoryById(id,token)
    }

    override fun onCleared() {
        super.onCleared()
        composite.dispose()
    }

}