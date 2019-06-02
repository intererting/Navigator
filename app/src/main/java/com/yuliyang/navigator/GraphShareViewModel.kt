package com.yuliyang.navigator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GraphShareViewModel : ViewModel() {

    val shareValue = MutableLiveData<String>()
}