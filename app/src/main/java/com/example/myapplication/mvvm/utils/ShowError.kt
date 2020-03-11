package com.example.myapplication.mvvm.utils

class ShowError (message: String, val  t: Throwable) : Throwable(message, t)