package com.example.ocha

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val frame = MutableLiveData<Int>()
}
