package com.example.myapplication.mvvm.repository

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.api.ApiUtils
import com.example.myapplication.mvvm.model.Subject
import com.example.myapplication.mvvm.model.SubjectsResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SubjectRepository(){
    private val composite=CompositeDisposable()

    fun getAllSubject(id:String){
        composite.add(ApiUtils.getApiService().getAllSubject(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
        )
    }

    private fun onGetAllSubject(response:SubjectsResponse){
        if(response.status=="1"){
            val data = MutableLiveData<List<Subject>>()
            data.value = response.data
        }
    }
}