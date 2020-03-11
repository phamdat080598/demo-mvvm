package com.example.myapplication.mvvm.viewmodel

import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.mvvm.ObservableViewModel
import com.example.myapplication.mvvm.utils.ShowError
import com.example.myapplication.repository.CategoryRepository
import kotlinx.coroutines.launch

class CategoryViewModel : ObservableViewModel() {

    private val repository = CategoryRepository()

    @get:Bindable
    var category = repository.category
        set(value) {
            field = value
            notifyPropertyChanged(BR.category)
        }

    private val _messageResponse = MutableLiveData<String>()
    val messageResponse
        get() = _messageResponse

    private fun launchLoadData(block: suspend () -> Unit) {
        viewModelScope.launch {
            try {
                block()
            }catch (error:ShowError){
                _messageResponse.value=error.message
                Log.d("ShowError",error.t.localizedMessage)
            }
        }
    }

    fun getCategoryById(id: String, token: String) = launchLoadData{
        repository.getCategoryById(id, token)
    }
}