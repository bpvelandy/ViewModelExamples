package com.bpv.vmapplication.share.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bpv.vmapplication.data.DataItem

class ActivityShareViewModel : ViewModel() {

    val listOfDataLiveData = MutableLiveData<List<DataItem>>()

    fun addData(title: String, number: Int?, description: String) {
        val list = listOfDataLiveData.value?.toMutableList() ?: ArrayList()
        list.add(DataItem(title, number, description))
        listOfDataLiveData.value = list
    }
}