package com.example.banksampah

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.banksampah.model.Sampah


class SampahAdapter (private val sampahList : ArrayList<Sampah>) :
    RecyclerView.Adapter<SampahAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.cv_datasampah,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = sampahList[position]
        holder.result_kategori.text = currentItem.kategori
        holder.result_subkategori.text = currentItem.subkategori

    }

    override fun getItemCount(): Int {

        return sampahList.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val result_kategori : TextView = itemView.findViewById(R.id.result_kategori)
        val result_subkategori : TextView = itemView.findViewById(R.id.result_subkategori)

    }
}