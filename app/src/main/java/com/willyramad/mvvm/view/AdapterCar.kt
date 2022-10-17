package com.willyramad.mvvm.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.willyramad.mvvm.R
import com.willyramad.mvvm.databinding.ItemCarBinding
import com.willyramad.mvvm.model.getAllDataCar
import com.willyramad.mvvm.model.getAllDataCarItem

class AdapterCar (): RecyclerView.Adapter<AdapterCar.ViewHolder>() {

    private var listCar : List<getAllDataCarItem>? = null

    fun setCarList(carList: List<getAllDataCarItem>){
        this.listCar = carList
    }
    class ViewHolder(var binding : ItemCarBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemCarBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvHarga.text = listCar!![position].price.toString()
        holder.binding.tvNama.text = listCar!![position].name
        Glide.with(holder.itemView).load(listCar!![position].image).into(holder.binding.tvImg)
    }

    override fun getItemCount(): Int {
        if (listCar == null){
            return 0
        }else{
            return listCar!!.size
        }
    }
}