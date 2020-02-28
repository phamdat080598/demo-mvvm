package com.example.myapplication.mvvm.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.myapplication.BR

class Category: BaseObservable(){


    @get:Bindable
    var id: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.id)
        }

    @get:Bindable
    var name: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }


    @get:Bindable
    var image: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.image)
        }


    @get:Bindable
    var type: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.type)
        }

}