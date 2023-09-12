package com.example.banksampah

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.banksampah.model.DataSampah


class InputSampahAdapter(private val addsampahList: MutableList<DataSampah>) :
    RecyclerView.Adapter<InputSampahAdapter.SampahMyViewHolder>()
    {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampahMyViewHolder {
            val itemView =
                LayoutInflater.from(parent.context).inflate(R.layout.cv_inputdatasampah, parent, false)
            return SampahMyViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: SampahMyViewHolder, position: Int) {
            val currentItem = addsampahList[position]
            holder.dataKategori.text = currentItem.kategori
            holder.dataSubkategori.text = currentItem.subkategori
//            holder.dataJumlah.text = currentItem.jumlah.toString()
        }

        override fun getItemCount(): Int {

            return addsampahList.size
        }

        class SampahMyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val dataKategori: TextView = itemView.findViewById(R.id.data_subkategori)
            val dataSubkategori: TextView = itemView.findViewById(R.id.data_kategori)
//            var dataJumlah: TextView = itemView.findViewById(R.id.data_jumlah)

        }
    }
