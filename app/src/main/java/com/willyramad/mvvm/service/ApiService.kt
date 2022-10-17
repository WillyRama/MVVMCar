package com.willyramad.mvvm.service

import com.willyramad.mvvm.model.getAllDataCarItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("admin/car")
    fun getAllCar(): Call<List<getAllDataCarItem>>
}