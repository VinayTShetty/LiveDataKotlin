package com.example.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class IncrementNumberViewModel: ViewModel() {

    var number =0
    /**
     * Live Data is something which we use to update the data automatically.
     */
    val currentNumber:MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    val CurrentnumberType:MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun incrementNumber(){
        number++
        currentNumber.value=number
        checkNumberEvenOdd()
    }

    fun checkNumberEvenOdd(){
        CurrentnumberType.value=number%2==0
    }
}