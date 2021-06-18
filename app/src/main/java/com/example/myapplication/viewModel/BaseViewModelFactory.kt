package com.example.myapplication.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BaseViewModelFactory(): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(BaseViewModel::class.java)){
            return BaseViewModel() as T
        }
        throw IllegalArgumentException ("UnknownViewModel")
    }

}