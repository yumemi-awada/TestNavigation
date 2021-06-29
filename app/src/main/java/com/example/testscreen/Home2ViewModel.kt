package com.example.testscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Home2ViewModel : ViewModel() {

    private val _count = MutableLiveData<Int>(0)
    val count: LiveData<Int> = _count

    fun setCount(count: Int) {
        _count.value = count
    }


}
