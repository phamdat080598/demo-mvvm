package com.example.myapplication.mvvm.viewmodel

import androidx.lifecycle.ViewModel

class SubjectViewModel() : ViewModel() {

    override fun onCleared() {
        super.onCleared()
        //dispose compisite
    }
}