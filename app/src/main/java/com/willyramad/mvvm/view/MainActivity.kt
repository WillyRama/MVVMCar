package com.willyramad.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.willyramad.mvvm.R
import com.willyramad.mvvm.databinding.ActivityMainBinding
import com.willyramad.mvvm.viewmodel.ViewModelCar

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var adapterCar: AdapterCar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapterCar = AdapterCar()

        binding.rvData.layoutManager = LinearLayoutManager(this)
        binding.rvData.adapter = adapterCar

        initViewModel()
    }
    fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(ViewModelCar::class.java)
        viewModel.tampilCar()
        viewModel.getLiveDataCa().observe(this, Observer {
            if (it != null){
                adapterCar.setCarList(it)

                adapterCar.notifyDataSetChanged()
            }
        })
        viewModel.getLiveDataCa()
    }
}