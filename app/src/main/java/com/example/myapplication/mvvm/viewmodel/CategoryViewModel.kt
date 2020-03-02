package com.example.myapplication.mvvm.viewmodel

import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.LiveData
import com.example.myapplication.mvvm.ObservableViewModel
import com.example.myapplication.repository.CategoryRepository

class CategoryViewModel : ObservableViewModel() {

    private val repository = CategoryRepository()

    @get:Bindable
    var category  = repository.category
        set(value) {
            field=value
            notifyPropertyChanged(BR.category)
        }

    val messageResponse : LiveData<String> by lazy {
        repository.messageResponse
    }

    fun getCategoryById(id:String,token:String){
        repository.getCategoryById(id,token)
    }

    override fun onCleared() {
        super.onCleared()
        repository.dispose()
    }

}