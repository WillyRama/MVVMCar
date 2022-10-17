package com.willyramad.mvvm.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.willyramad.mvvm.model.getAllDataCarItem
import com.willyramad.mvvm.service.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelCar :ViewModel(){
    lateinit var liveDataCar : MutableLiveData<List<getAllDataCarItem>>

    init {
        liveDataCar = MutableLiveData()
    }

    fun getLiveDataCa(): MutableLiveData<List<getAllDataCarItem>>{
        return liveDataCar
    }
    fun tampilCar(){
        ApiClient.instance.getAllCar()
            .enqueue(object : Callback<List<getAllDataCarItem>>{
                override fun onResponse(
                    call: Call<List<getAllDataCarItem>>,
                    response: Response<List<getAllDataCarItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataCar.postValue(response.body())
                    }else{
                        liveDataCar.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<getAllDataCarItem>>, t: Throwable) {
                   liveDataCar.postValue(null)
                }

            })
    }
}