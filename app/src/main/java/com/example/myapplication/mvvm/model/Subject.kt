package com.example.myapplication.mvvm.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.myapplication.BR

data class Subject(
   private var name: String,
   private var id: String,
   private var id_department: String,
   private var credits: String
) : BaseObservable(){

    var _name: String
   @Bindable get() = name
    set(value) {
        name=value
        notifyPropertyChanged(BR._name)
    }

    var _id :String
    @Bindable get() = id
    set(value) {
        id=value
        notifyPropertyChanged(BR._id)
    }

    var _id_department:String
    @Bindable get() = id_department
    set(value) {
        id_department=value
        notifyPropertyChanged(BR._id_department)
    }

    var _credits:String
    @Bindable get() = credits
    set(value) {
        credits = value
        notifyPropertyChanged(BR._credits)
    }
}